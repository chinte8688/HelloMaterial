package com.simon.hellomaterial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lp43 on 2014/8/4.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private static Context context;
    private static ItemData[] itemsData;

    public MyAdapter(Context cnx, ItemData[] itemsData) {
        this.context = cnx;
        this.itemsData = itemsData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, null);

        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.txtViewTitle.setText(itemsData[position].getTitle());
        viewHolder.imgViewIcon.setImageResource(itemsData[position].getImageSmall());
        viewHolder.setOnItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 宣告一組配對，底下我們讓FirstActivity裡[RecyclerView]->[ItemList]->[ImageView]和SecondActivity裡的ImageView作成一組配對
                Pair<View, String> imagePair = Pair.create((View) viewHolder.imgViewIcon, "tImage");

                Intent transitionIntent = new Intent( context, SecondActivity.class);
                transitionIntent.putExtra("imageRes", itemsData[position].getImageLarge());
                // 製作成 Material Design 需要的 ActivityOptionsCompat
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)context, imagePair);
                ActivityCompat.startActivity((Activity)context, transitionIntent, options.toBundle());
            }
        });
    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.length;
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View itemLayoutView;
        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            this.itemLayoutView = itemLayoutView;
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        }

        public void setOnItemClick(View.OnClickListener l){
            this.itemLayoutView.setOnClickListener(l);
        }

    }
}
