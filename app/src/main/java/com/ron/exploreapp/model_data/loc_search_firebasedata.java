package com.ron.exploreapp.model_data;

import java.io.Serializable;
import java.util.List;

public class loc_search_firebasedata implements Serializable {

    Float lat;
    Float lon;
    String place;
    rest_firebasedata rest_firebasedata;
    String state;



    public loc_search_firebasedata(){}

    public loc_search_firebasedata( Float lat, Float lon, String place,rest_firebasedata rest_firebasedata, String state) {

        this.lat = lat;
        this.lon = lon;
        this.place = place;
        this.rest_firebasedata=rest_firebasedata;
        this.state = state;

    }

    public com.ron.exploreapp.model_data.rest_firebasedata getRest_firebasedata() {
        return rest_firebasedata;
    }

    public void setRest_firebasedata(com.ron.exploreapp.model_data.rest_firebasedata rest_firebasedata) {
        this.rest_firebasedata = rest_firebasedata;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setState(String state) {
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



