package com.example.hf7;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private String info;
    private int img;

    public Animal(String name, String info, int img) {
        this.name = name;
        this.info = info;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return info;
    }

    public int getImg() {
        return img;
    }
}
