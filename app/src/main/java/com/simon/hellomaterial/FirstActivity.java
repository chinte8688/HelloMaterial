package com.simon.hellomaterial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by ehs_Simon on 2016/1/14.
 */
public class FirstActivity extends Activity {
    private ImageView placeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        placeImage = (ImageView) findViewById(R.id.placeImage);
        placeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 宣告一組元件配對，底下我們讓FirstActivity裡的ImageView和SecondActivity裡的ImageView作為一組配對
                Pair<View, String> imagePair = Pair.create((View) placeImage, "tImage");

                Intent transitionIntent = new Intent(FirstActivity.this, SecondActivity.class);
                // 製作成 Material Design 需要的 ActivityOptionsCompat
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(FirstActivity.this, imagePair);
                ActivityCompat.startActivity(FirstActivity.this, transitionIntent, options.toBundle());
            }
        });
    }
}
