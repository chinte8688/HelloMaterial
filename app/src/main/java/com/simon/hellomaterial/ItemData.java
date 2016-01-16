package com.simon.hellomaterial;

/**
 * Created by lp43 on 2014/8/4.
 */
public class ItemData {
    private String title;
    private int image;

    public ItemData(String title, int res){

        this.title = title;
        this.image = res;

    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
