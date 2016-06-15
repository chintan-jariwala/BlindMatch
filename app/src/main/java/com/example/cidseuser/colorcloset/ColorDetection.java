package com.example.cidseuser.colorcloset;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by cidseuser on 6/15/2016.
 */
public class ColorDetection {
    String color;

    public ColorDetection(Bitmap image) throws Exception{

        int height = image.getHeight();
        int width = image.getWidth();

        Map m = new HashMap();

        for(int i = 0; i < width; i++){

            for(int j = 0; j < height; j++){

                int rgb = image.getPixel(i, j);
                int[] rgbArr = getRGBArr(rgb);

                if(!isGray(rgbArr)){

                    Integer counter = (Integer) m.get(rgb);
                    if(counter == null){
                        counter = 0;
                    }
                    counter++;
                    m.put(rgb, counter);

                }

            }

        }

        String colorHex = getMostCommonColor(m);

    }

    public String getMostCommonColor(Map map){
        //todo: fix this guy

        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {

                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());

            }

        });

        Map.Entry me = (Map.Entry)list.get(list.size()-1);
        int[] rgb = getRGBArr((Integer)me.getKey());

        return Integer.toHexString(rgb[0])+" "+Integer.toHexString(rgb[1])+" "+Integer.toHexString(rgb[2]);

    }

    public int[] getRGBArr(int pixel){

        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;

        return new int[]{red, green, blue};

    }

    public boolean isGray(int[] rgbArr){

        int rgDiff = rgbArr[0] - rgbArr[1];
        int rbDiff = rgbArr[0] - rgbArr[2];

        int tolerance = 10;

        if(rgDiff > tolerance || rgDiff < -tolerance){
            if(rbDiff > tolerance || rbDiff < -tolerance){
                return false;
            }
        }
        return true;
    }

    public String returnColor(){

        if(color.length() == 6){
            return color.replaceAll("\\s", "");
        }
        else{
            return "ffffff";
        }

    }


    //This actually retrieves the average rgb color

    /*public int getDominantColor(Bitmap bitmap){
        if (null == bitmap) return Color.TRANSPARENT;
        int redBucket = 0;
        int greenBucket = 0;
        int blueBucket = 0;
        int alphaBucket = 0;
        boolean hasAlpha = bitmap.hasAlpha();
        int pixelCount = bitmap.getWidth() * bitmap.getHeight();
        int[] pixels = new int[pixelCount];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int y = 0, h = bitmap.getHeight(); y < h; y++)
        {
            for (int x = 0, w = bitmap.getWidth(); x < w; x++)
            {
                int color = pixels[x + y * w]; // x + y * width
                redBucket += (color >> 16) & 0xFF; // Color.red
                greenBucket += (color >> 8) & 0xFF; // Color.greed
                blueBucket += (color & 0xFF); // Color.blue
                if (hasAlpha) alphaBucket += (color >>> 24); // Color.alpha
            }
        }
        return Color.argb(
                (hasAlpha) ? (alphaBucket / pixelCount) : 255,
                redBucket / pixelCount,
                greenBucket / pixelCount,
                blueBucket / pixelCount);
    }*/

    //This retrieves the dominant rbg value in an image
}
