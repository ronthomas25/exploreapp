package com.ron.exploreapp.model_data;

import java.io.Serializable;

public class hotels_data implements Serializable {

    String desc;
    String img_inner;
    String img_outer;
    Float lat;
    Float lon;
    String place;
    Float rating;
    String state;

    public hotels_data(String desc, String img_inner, String img_outer, Float lat, Float lon, String place, Float rating, String state) {
        this.desc = desc;
        this.img_inner = img_inner;
        this.img_outer = img_outer;
        this.lat = lat;
        this.lon = lon;
        this.place = place;
        this.rating = rating;
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg_inner() {
        return img_inner;
    }

    public String getImg_outer() {
        return img_outer;
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