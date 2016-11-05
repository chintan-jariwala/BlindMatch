package com.example.cidseuser.colorcloset;
import android.graphics.Color;

import java.util.List;
import java.lang.*;
/**
 * Created by cidseuser on 6/14/2016.
 */
public class Clothing {
    public Clothing(int rgb, String[] tags, String description) {
        color = rgb;
    }

    private List<Top> tops;
    private List<Bottom> bottoms;
    private String color;
    private String photofilepath;
    private int id;

    public String getColor(){ return color; }
    public String getPhotofilepath(){ return photofilepath; }
    public int getId(){ return id; }
}
