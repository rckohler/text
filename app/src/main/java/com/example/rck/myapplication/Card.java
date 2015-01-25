package com.example.rck.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;

import java.io.InputStream;

/**
 * Created by rck on 1/24/2015.
 */
public class Card {

    String description;
    Bitmap bitmap;
    RectF bounds;
    TextBox textBox;

    int textSize;
    int spacer;

    public Card(Bitmap bitmap, String description, RectF bounds, int textSize, int charactersPerLine  ){
        this.description = description;
        this.bitmap = bitmap;
        this.bounds = bounds;
        textBox = new TextBox(bounds,description,textSize, charactersPerLine);
    }

    public void update(Canvas canvas){
        if (bitmap != null)
            canvas.drawBitmap(bitmap,null,bounds,null);
         textBox.update(canvas);
    }
}
