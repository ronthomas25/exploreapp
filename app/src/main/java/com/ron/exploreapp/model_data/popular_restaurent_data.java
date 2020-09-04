package com.ron.exploreapp.model_data;

import java.io.Serializable;

public class popular_restaurent_data implements Serializable {
    String img;
    String placename;
    String desc;
    float rating;
    float lat,lon;
    String state;

    public popular_restaurent_data(){}


        public popular_restaurent_data(String img, String placename, String desc, double rating, double lat, double lon, String state) {
            this.img = img;
            this.placename = placename;
            this.desc = desc;
            this.rating = (float) rating;
            this.lat = (float) lat;
            this.lon = (float) lon;
            this.state = state;

        }

        public float getLat() {
            return lat;
        }

        public void setLat(float lat) {
            this.lat = lat;
        }

        public float getLon() {
            return lon;
        }

        public void setLon(float lon) {
            this.lon = lon;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }


        public float getRating() {
            return rating;
        }

        public void setRating(float rating) {
            this.rating = rating;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImg() {
            return img;
        }

        public String getPlacename() {
            return placename;
        }

        public void setPlacename(String placename) {
            this.placename = placename;
        }
    }

