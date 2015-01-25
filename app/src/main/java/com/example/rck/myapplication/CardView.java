package com.example.rck.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by rck on 1/24/2015.
 */
public class CardView extends View {
    MainActivity main;
    CardFactory cardFactory;
    public CardView(Context context) {
        super(context);
        main = (MainActivity)context;
        cardFactory = CardFactory.getInstance(context,"a.txt");
    }
    protected void onDraw(Canvas canvas) {
        cardFactory.chooseRandomCard();
        if (cardFactory.currentCard.bitmap != null)
            cardFactory.currentCard.update(canvas);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) { }
        invalidate();
    }
}
