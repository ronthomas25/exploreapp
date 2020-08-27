package com.ron.exploreapp.model_data;

public class rest_firebasedata {
  String desc;
  String image;
  float lat;
  float lon;
  String place;
  float rating;
  String state;

  public rest_firebasedata(){ }

    public rest_firebasedata(String desc, String image, float lat, float lon, String place, float rating, String state) {
        this.desc = desc;
        this.image = image;
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