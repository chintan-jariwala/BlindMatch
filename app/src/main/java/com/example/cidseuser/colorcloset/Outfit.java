package com.example.cidseuser.colorcloset;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.List;


/**
 * Created by cidseuser on 6/14/2016.
 */
public class Outfit {

    /*public static final int IMAGE_GALLERY_REQUEST = 20;
    private gridView imgPicture;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            if(requestCode == IMAGE_GALLERY_REQUEST){
                Uri imageUri = data.getData();
                InputStream inputStream;
                try{
                    inputStream = getContentResolver().openInputStream(imageUri);

                    Bitmap image = BitmapFactory.decodeStream(inputStream);


                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText()
                }
            }
        }
    }*/

    public static int getComplementaryColor(int colorToInvert) {
        float[] hsv = new float[3];
        Color.RGBToHSV(Color.red(colorToInvert), Color.green(colorToInvert),
                Color.blue(colorToInvert), hsv);
        hsv[0] = (hsv[0] + 180) % 360;

        Log.e("Outfit", "HSV: " + hsv[0] + " " + hsv[1] + " " + hsv[2]);

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
