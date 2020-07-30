package com.ron.exploreapp.model_data;

public class mostsearched_data {
    int img;
    String placename;

    public mostsearched_data(int img, String placename) {
        this.img = img;
        this.placename = placename;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }
}
