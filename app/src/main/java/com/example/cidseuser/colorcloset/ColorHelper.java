package com.example.cidseuser.colorcloset;

import android.graphics.Color;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by cidseuser on 6/14/2016.
 */
public class ColorHelper {

    static Map<String, Integer> colorMap;


    private static void init(){
        if (colorMap == null) {
            colorMap = new HashMap<String, Integer>();
            colorMap.put(Integer.toString(Color.rgb(255, 255, 255)),Color.rgb(255,255,255));
            colorMap.put(Integer.toString(Color.rgb(0,0,0)),Color.rgb(0,0,0));
            colorMap.put(Integer.toString(Color.rgb(0,0,255)),Color.rgb(0,0,0));
            colorMap.put(Integer.toString(Color.rgb(255,255,0)),Color.rgb(255,255,0));
            colorMap.put(Integer.toString(Color.rgb(255,104,31)),Color.rgb(255,104,31));
            colorMap.put(Integer.toString(Color.rgb(128,128,128)),Color.rgb(128,128,128));
//            colorMap.put(Integer.toString(Color.rgb(255, 255, 255)),Color.rgb(255,255,255));
//            colorMap.put(Integer.toString(Color.rgb(0,0,0)),Color.rgb(0,0,0));
//            colorMap.put(Integer.toString(Color.rgb(0,0,255)),Color.rgb(0,0,0));
//            colorMap.put(Integer.toString(Color.rgb(255,255,0)),Color.rgb(255,255,0));
//            colorMap.put(Integer.toString(Color.rgb(255,104,31)),Color.rgb(255,104,31));
//            colorMap.put(Integer.toString(Color.rgb(128,128,128)),Color.rgb(128,128,128));

            /*
            colorMap.put("blue",Color.rgb(0,0,255));
            colorMap.put("green",Color.rgb(0,255,0));
            colorMap.put("yellow",Color.rgb(255,255,0));
            colorMap.put("orange",Color.rgb(255,104,31));
            colorMap.put("white",Color.rgb(255,255,255));
            colorMap.put("black",Color.rgb(0,0,0));
            colorMap.put("gray",Color.rgb(128,128,128));
            */
        }
        //int x = Color.rgb(1, 1, 1);
    }

    public static int getBestMatchingColorName(int pixelColor) {
        init();
        // largest difference is 255 for every colour component
        int currentDifference = 3 * 255;
        // name of the best matching colour
        String closestColorName = "-1";
        // get int values for all three colour components of the pixel
        int pixelColorR = Color.red(pixelColor);
        int pixelColorG = Color.green(pixelColor);
        int pixelColorB = Color.blue(pixelColor);

        Iterator<String> colorNameIterator = colorMap.keySet().iterator();
        // continue iterating if the map contains a next colour and the difference is greater than zero.
        // a difference of zero means we've found an exact match, so there's no point in iterating further.
        while (colorNameIterator.hasNext() && currentDifference > 0) {
            // this colour's name
            String currentColorName = colorNameIterator.next();
            // this colour's int value
            int color = colorMap.get(currentColorName);
            // get int values for all three colour components of this colour
            int colorR = Color.red(color);
            int colorG = Color.green(color);
            int colorB = Color.blue(color);
            // calculate sum of absolute differences that indicates how good this match is
            int difference = Math.abs(pixelColorR - colorR) + Math.abs(pixelColorG - colorG) + Math.abs(pixelColorB - colorB);
            // a smaller difference means a better match, so keep track of it
            if (currentDifference > difference) {
                currentDifference = difference;
                closestColorName = currentColorName;
            }
        }
        return Integer.parseInt(closestColorName);
    }
}
