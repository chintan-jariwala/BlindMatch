package com.example.mark.myapplication;
import android.graphics.Color;

import java.util.List;
import java.lang.Boolean;
import java.lang.*;


/**
 * Created by cidseuser on 6/13/2016.
 */
public abstract class Clothing {

    public Clothing(int rgb, String[] tags, String description) {
        color = rgb;
    }

    private List<Top> tops;
    private List<Bottom> bottoms;
    private int color;

    public int getColor(){ return color; }
}
