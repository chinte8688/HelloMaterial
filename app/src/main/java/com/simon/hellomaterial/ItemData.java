package com.simon.hellomaterial;

/**
 * Created by lp43 on 2014/8/4.
 */
public class ItemData {
    private String title;
    private int imageSmall;
    private int imageLarge;

    public ItemData(String title, int imgSmall, int imgLarge){
        this.title = title;
        this.imageSmall = imgSmall;
        this.imageLarge = imgLarge;
    }

    public String getTitle() {
        return title;
    }

    public int getImageLarge() {
        return imageLarge;
    }
    public int getImageSmall() {
        return imageSmall;
    }
}
