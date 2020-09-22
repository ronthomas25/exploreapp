package com.ron.exploreapp.model_data;

public class Notification {
    private String title;
    private String description;
    private String image;
    private int priority;

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Notification() {

    }

    public Notification(String title, String description,String image, int priority) {

        this.title = title;
        this.description = description;
        this.image=image;
        this.priority = priority;

    }
}
