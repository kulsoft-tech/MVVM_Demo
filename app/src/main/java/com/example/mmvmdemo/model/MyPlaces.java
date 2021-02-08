package com.example.mmvmdemo.model;

public class MyPlaces {

    public String name;
    public String image;

    public MyPlaces(String name, String image) {
        this.name = name;
        this.image  = image;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
