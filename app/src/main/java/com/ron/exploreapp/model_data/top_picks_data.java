package com.ron.exploreapp.model_data;

import java.io.Serializable;

public class top_picks_data implements Serializable {
   String desc;
   String image;
   String image_inner;
   Float lat;
   Float lon;
   String place;
   Float rating;
   String state;

   public top_picks_data(){}

    public top_picks_data(String desc, String image,String image_inner, Float lat, Float lon, String place, Float rating, String state) {
        this.desc = desc;
        this.image = image;
        this.image_inner=image_inner;
        this.lat = lat;
        this.lon = lon;
        this.place = place;
        this.rating = rating;
        this.state = state;
    }

    public String getImage_inner() {
        return image_inner;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }

    public Float getLat() {
        return lat;
    }

    public Float getLon() {
        return lon;
    }

    public String getPlace() {
        return place;
    }

    public Float getRating() {
        return rating;
    }

    public String getState() {
        return state;
    }
}