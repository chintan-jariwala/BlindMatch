package com.example.cidseuser.colorcloset;
import java.util.ArrayList;
import java.lang.Boolean;
import java.lang.*;


/**
 * Created by cidseuser on 6/13/2016.
 */
public abstract class Clothing {

    public clothing(int rgb, String[] tags, sring description) {
        color = Color.parseColor(rgb);
    }

    private ArrayList<Top> tops;
    private ArrayList<Bottom> bottoms;
    private Color color;

    public Clothing(ArrayList<Top> tops, ArrayList<Bottom> bottoms){
        this.tops = tops;
        this.bottoms = bottoms;
    }

    public class Top extends Clothing {
        public Top(String c){
            super(c);
        }
    }

    public class Bottom extends Clothing {
        public Bottom(String c){
            super(c);
        }
    }
}
