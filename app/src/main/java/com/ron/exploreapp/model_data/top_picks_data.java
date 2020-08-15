package com.ron.exploreapp.model_data;

import java.io.Serializable;

public class top_picks_data implements Serializable {
    int img[];
    String placename;
    String desc;
    double rating;
    double lat,lon;
    String state;

    public top_picks_data(int[] img, String placename, String desc, double rating, double lat, double lon, String state) {
        this.img = img;
        this.placename = placename;
        this.desc = desc;
        this.rating = rating;
        this.lat = lat;
        this.lon = lon;
        this.state = state;
    }

    public int getImg(int i) {

        return img[i];
    }

    public void setImg(int[] img) {
        this.img = img;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
