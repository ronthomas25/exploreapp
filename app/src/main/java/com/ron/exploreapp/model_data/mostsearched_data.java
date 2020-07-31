package com.ron.exploreapp.model_data;
import java.io.Serializable;

public class mostsearched_data implements Serializable {
    int img[];
    String placename;
    String desc;

    public mostsearched_data(int[] img, String placename, String desc) {
        this.img = img;
        this.placename = placename;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg(int i) {
        return img[i];
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }
}
