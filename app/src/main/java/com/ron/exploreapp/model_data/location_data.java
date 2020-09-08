package com.ron.exploreapp.model_data;

import java.io.Serializable;

public class location_data implements Serializable {
    String img;
    Float lat;
    Float lon;
    String place;
   // Float rating;
    String state;

    public location_data(){}

    public location_data( String img, Float lat, Float lon, String place, String state) {
        this.img = img;
        this.lat = lat;
        this.lon = lon;
        this.place = place;
        this.state = state;
    }

    public String getImg() { return img; }

    public Float getLat() {
        return lat;
    }

    public Float getLon() {
        return lon;
    }

    public String getPlace() {
        return place;
    }


    public String getState() {
        return state;
    }
}
