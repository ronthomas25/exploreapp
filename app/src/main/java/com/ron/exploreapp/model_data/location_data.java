package com.ron.exploreapp.model_data;

import java.io.Serializable;

public class location_data implements Serializable {
    Float lat;
    Float lon;
    String place;
   // Float rating;
    String state;

    public location_data(){}

    public location_data( Float lat, Float lon, String place, String state) {

        this.lat = lat;
        this.lon = lon;
        this.place = place;
        this.state = state;
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


    public String getState() {
        return state;
    }
}
