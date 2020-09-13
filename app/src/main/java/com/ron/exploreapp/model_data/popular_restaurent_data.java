package com.ron.exploreapp.model_data;

import java.io.Serializable;

public class popular_restaurent_data implements Serializable {
    String desc;
    String image;
    String imageinner;
    float lat;
    float lon;
    String place;
    float rating;
    String state;

    public popular_restaurent_data() {
    }

    public popular_restaurent_data(String desc, String image, String imageinner, float lat, float lon, String place, float rating, String state) {
        this.desc = desc;
        this.image = image;
        this.imageinner = imageinner;
        this.lat = lat;
        this.lon = lon;
        this.place = place;
        this.rating = rating;
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public String getImageInner() {
        return imageinner;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public String getPlace() {
        return place;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getState() {
        return state;
    }
}