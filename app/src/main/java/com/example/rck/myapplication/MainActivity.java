package com.example.rck.myapplication;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;


public class MainActivity extends ActionBarActivity {
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Vector<String> bitmapNames = new Vector<String>();
        Vector<String> descriptions = new Vector<String>();

        AssetManager assetManager = getAssets();

        InputStream is = null;
        BufferedReader reader;
        String sCurrentLine;
        String cardBitmapName;
        String cardDescription;
        try {
            is = assetManager.open("a.txt");
            reader = new BufferedReader(new InputStreamReader(is));
            System.out.println("Here: " + reader.toString());
            while ((sCurrentLine = reader.readLine()) != null) {
                if (sCurrentLine == "bName")
                {
                    cardBitmapName = sCurrentLine;
                    bitmapNames.add(cardBitmapName);
                }
                if (sCurrentLine == "description")
                {
                    cardDescription = sCurrentLine;
                    bitmapNames.add(cardDescription);
                }
            }
        }
        catch (IOException e){
            System.out.println("rck: failure");
        }
        for (int i = 0; i <bitmapNames.size(); i++){
            System.out.println(bitmapNames.elementAt(i));
            System.out.println(descriptions.elementAt(i));
        }
        //BufferedReader reader = new BufferedReader(new InputStreamReader(iS));
    }
    private void loadBitmaps(){
        int bitmapName = R.drawable.zombie1;
        bitmap = BitmapFactory.decodeResource(getResources(), bitmapName);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
