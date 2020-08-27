package com.ron.exploreapp;

public class Notification {
    private String title;
    private String description;
    private int priority;

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

    public Notification(String title, String description, int priority) {

        this.title = title;
        this.description = description;
        this.priority = priority;

    }
}
