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

import com.squareup.picasso.Picasso;

/**
 * Created by lp43 on 2014/8/4.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private static Context context;
    private ItemData[] itemsData;

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
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.txtViewTitle.setText(itemsData[position].getTitle());
        viewHolder.imgViewIcon.setImageResource(itemsData[position].getImageResource());


        Picasso.with(viewHolder.imgViewIcon.getContext()).load(itemsData[position].getImageResource()).into(viewHolder.imgViewIcon);
    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.length;
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            itemLayoutView.setOnClickListener(this);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        }

        @Override
        public void onClick(View view) {
            // 宣告一組元件配對，底下我們讓FirstActivity裡的ImageView和SecondActivity裡的ImageView作為一組配對
            Pair<View, String> imagePair = Pair.create((View) imgViewIcon, "tImage");

            Intent transitionIntent = new Intent( context, SecondActivity.class);
            // 製作成 Material Design 需要的 ActivityOptionsCompat
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)context, imagePair);
            ActivityCompat.startActivity((Activity)context, transitionIntent, options.toBundle());
        }
    }
}
