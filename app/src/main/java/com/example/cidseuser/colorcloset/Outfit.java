package com.example.mark.myapplication;
import android.graphics.Color;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by cidseuser on 6/13/2016.
 */
public class Outfit {

    public static int getComplementaryColor(int colorToInvert) {
        float[] hsv = new float[3];
        Color.RGBToHSV(Color.red(colorToInvert), Color.green(colorToInvert),
                Color.blue(colorToInvert), hsv);
        hsv[0] = (hsv[0] + 180) % 360;

        //TODO: narrow this color down to just primary colors (or limited set of colors)
        return Color.HSVToColor(hsv);
    }
    public List<Clothing> Filter(List<Clothing> clothes){
        // get complement of either top or bottom (whichever is not null)
        // create a new list of clothes filtered based on the complementary color
        // return this new list
        List<Clothing> result = null;
        if(top != null){
            int comp = getComplementaryColor(top.getColor());
            //todo: log value of comp

            // convert complementary color to a simple color
            comp = ColorHelper.getBestMatchingColorName(comp);

            for(Clothing c : clothes){
                if(c.getColor() == comp)
                    result.add((Clothing) c);
            }
        } else {
            int comp = getComplementaryColor(bottom.getColor());
            //todo: log value of comp

            for(Clothing c : clothes){
                if(c.getColor() == comp)
                    result.add((Clothing) c);
            }
        }


        //todo: log result.count
        return result;
    }

    private Top top;
    private Bottom bottom;

    public void setTop(Top top){
        this.top = top;
    }

    public Top getTop(){
        return top;
    }

    public void setBottom(Bottom bottom){
        this.bottom = bottom;
    }

    public Bottom GetBottom(){
        return bottom;
    }
}
