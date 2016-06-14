package com.example.mark.myapplication;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cidseuser on 6/13/2016.
 */
public class Wardrobe {

    public Wardrobe(List<Clothing> tops, List<Clothing> bottoms){
        this.tops = tops;
        this.bottoms = bottoms;
    }

    private List<Clothing> tops;
    private List<Clothing> bottoms;

    public List<Clothing> getTops(){
        // todo: return only tops
        return tops;
    }

    public List<Clothing> getBottoms(){
        // todo: return only bottoms
        return bottoms;
    }
}
