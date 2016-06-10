package com.example.cidseuser.colorcloset;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Hashtable;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.shirt_test);

        /*
        ColorDetection colorDet = null;

        try {
            colorDet = new ColorDetection(bMap);
        } catch (Exception exc) {
            //TODO: handle this
        }
        Hashtable myMap = new Hashtable();
        myMap.put("tshirt", 15);
        myMap.put("polo", 4);
        myMap.put("longsleeve", 2);
        */

        String dominantColor = getDominantColor(bMap); //colorDet.getMostCommonColor(myMap);

        Log.e("MainActivity","Value -= " + dominantColor);

        /*ColorDetection colorDet = new ColorDetection();
        int x = colorDet.getDominantColor(bMap);
        Log.e("MainActivity","Value -= " + x);*/

       // Toast.makeText(this,"MainActivity","Value -= ",Toast.LENGTH_LONG).show();
//
    }


    protected String getDominantColor(Bitmap bitmap) {
        Bitmap tempBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
        int color = tempBitmap.getPixel(0, 0);
        int red = Color.red(color);
        int blue = Color.blue(color);
        int green = Color.green(color);

        Log.e("getDominantColor","red -= " + red);
        Log.e("getDominantColor","blue -= " + blue);
        Log.e("getDominantColor","green -= " + green);

        Log.e("getDominantColor","color -= " + color);
        return Integer.toHexString(color);
    }


}
