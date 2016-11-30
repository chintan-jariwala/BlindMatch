package com.example.cidseuser.colorcloset;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by cidseuser on 6/14/2016.
 */
public class Wardrobe {

    //region MEMBERS
    private static Wardrobe sWardrobe;
    private Context mAppContext;
    private ArrayList<Clothing> tops;
    private ArrayList<Clothing> bottoms;
    private static final String JSON_ID = "id";
    private static final String JSON_COLOR = "color";
    private static final String JSON_PHOTOFILEPATH = "photofilepath";

    private UUID id;
    private String color;
    private String photofilepath;

    private static final String TAG = "SaveClothing";
    private static final String TOPS_FILENAME = "tops.wardrobe.json";
    private static final String BOTTOMS_FILENAME = "bottoms.wardrobe.json";

    private ClothingJSONSerializer topsSerializer;
    private ClothingJSONSerializer bottomsSerializer;
    //endregion

    //region CONSTRUCTORS
    public static Wardrobe get(Context c){
        if (sWardrobe == null) {
            sWardrobe = new Wardrobe(c.getApplicationContext());
        }
        return sWardrobe;
    }

    public Wardrobe(){

    }
    //endregion


    private Wardrobe(Context appContext){
        mAppContext = appContext;
        tops = new ArrayList<>();
        bottoms =new ArrayList<>();

        topsSerializer = new ClothingJSONSerializer(mAppContext, TOPS_FILENAME);

        try{
            tops = topsSerializer.loadClothes();
        }
        catch (Exception e){
            Log.e(TAG, "Error loading tops: ", e);
        }

        bottomsSerializer = new ClothingJSONSerializer(mAppContext, BOTTOMS_FILENAME);

        try{
            bottoms = bottomsSerializer.loadClothes();
        }
        catch (Exception e){
            Log.e(TAG, "Error loading bottoms: ", e);
        }
    }

    //region PUBLIC METHODS
    public ArrayList<Clothing> getTops(){
        return tops;
    }

    public ArrayList<Clothing> getBottoms(){
        return bottoms;
    }

    public boolean save(){
        try{
            topsSerializer.saveClothes(tops);
            Log.d(TAG, "clothing saved to file");
            return true;
        }
        catch (Exception e){
            Log.e(TAG, "Error saving clothing: ", e);
            return false;
        }
    }
    //endregion
}
