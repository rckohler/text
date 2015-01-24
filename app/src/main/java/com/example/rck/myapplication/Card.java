package com.example.rck.myapplication;

import android.graphics.Bitmap;

/**
 * Created by rck on 1/24/2015.
 */
public class Card {
    String bName;
    String description;
    Bitmap bitmap;
    public Card(String bName, String description){
        this.bName = bName;
        this.description = description;
    }
}
