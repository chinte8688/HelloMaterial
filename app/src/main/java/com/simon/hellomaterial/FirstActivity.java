package com.simon.hellomaterial;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ehs_Simon on 2016/1/14.
 */
public class FirstActivity extends Activity {

    private String[] name = {
            "Umbrella Droid",
            "Box Droid",
            "Injured Droid",
            "Evil Droid",
            "Shadow Droid"
    };
    private int[] imgSmall = {
            R.drawable.droid1_s,
            R.drawable.droid2_s,
            R.drawable.droid3_s,
            R.drawable.droid4_s,
            R.drawable.droid5_s
    };
    private int[] imgLarge = {
            R.drawable.droid1_l,
            R.drawable.droid2_l,
            R.drawable.droid3_l,
            R.drawable.droid4_l,
            R.drawable.droid5_l
    };

    // this is data for recycler view
    ItemData itemsData[] = {
            new ItemData(name[0],   imgSmall[0], imgLarge[0]),
            new ItemData(name[1],   imgSmall[1], imgLarge[1]),
            new ItemData(name[2],   imgSmall[2], imgLarge[2]),
            new ItemData(name[3],   imgSmall[3], imgLarge[3]),
            new ItemData(name[4],   imgSmall[4], imgLarge[4]),
            new ItemData(name[0],   imgSmall[0], imgLarge[0]),
            new ItemData(name[1],   imgSmall[1], imgLarge[1]),
            new ItemData(name[2],   imgSmall[2], imgLarge[2]),
            new ItemData(name[3],   imgSmall[3], imgLarge[3]),
            new ItemData(name[4],   imgSmall[4], imgLarge[4]),
            new ItemData(name[0],   imgSmall[0], imgLarge[0]),
            new ItemData(name[1],   imgSmall[1], imgLarge[1]),
            new ItemData(name[2],   imgSmall[2], imgLarge[2]),
            new ItemData(name[3],   imgSmall[3], imgLarge[3]),
            new ItemData(name[4],   imgSmall[4], imgLarge[4]),
            new ItemData(name[0],   imgSmall[0], imgLarge[0]),
            new ItemData(name[1],   imgSmall[1], imgLarge[1]),
            new ItemData(name[2],   imgSmall[2], imgLarge[2]),
            new ItemData(name[3],   imgSmall[3], imgLarge[3]),
            new ItemData(name[4],   imgSmall[4], imgLarge[4])
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter mAdapter = new MyAdapter(this, itemsData);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
