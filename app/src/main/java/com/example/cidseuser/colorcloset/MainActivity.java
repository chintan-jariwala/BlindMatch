package com.example.cidseuser.colorcloset;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.shirt_test);

        ColorDetection colorDet = new ColorDetection();
        int x = colorDet.getDominantColor(bMap);

        Log.i("MainActivity","Value -= " + x);

    }
}
