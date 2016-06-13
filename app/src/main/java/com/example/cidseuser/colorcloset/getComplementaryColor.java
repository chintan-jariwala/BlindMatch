package com.example.cidseuser.colorcloset;
import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by cidseuser on 6/13/2016.
 */
public class getComplementaryColor {

    public static int getComplementaryColor(int colorToInvert) {
        float[] hsv = new float[3];
        Color.RGBToHSV(Color.red(colorToInvert), Color.green(colorToInvert),
                Color.blue(colorToInvert), hsv);
        hsv[0] = (hsv[0] + 180) % 360;
        return Color.HSVToColor(hsv);
    }
}