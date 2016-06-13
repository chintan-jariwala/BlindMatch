package com.example.cidseuser.colorcloset;
import java.util.ArrayList;
import java.lang.Boolean;
import java.lang.*;


/**
 * Created by cidseuser on 6/13/2016.
 */
public class Clothing {

    public String hexvalue;
    //public Boolean pattern;

    public Clothing(String hvalue){
        hexvalue = hvalue;
    }

    private ArrayList<Top> tops;
    private ArrayList<Bottom> bottoms;

    public Clothing(ArrayList<Top> tops, ArrayList<Bottom> bottoms){
        this.tops = tops;
        this.bottoms = bottoms;
    }

    public class Top extends Clothing {
        //Here the code will check the hex value and categorize it in one color:
        public Top(String hvalue){
            super(hvalue);
        }
    }

    public class Bottom extends Clothing {
        public Bottom(String hvalue){
            super(hvalue);
        }
    }



}
