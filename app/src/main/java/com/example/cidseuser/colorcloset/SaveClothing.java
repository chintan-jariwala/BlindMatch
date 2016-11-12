package com.example.cidseuser.colorcloset;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by temp6435 on 11/5/2016.
 */
public class SaveClothing {

    private static final String TAG = "SaveClothing";
    private static final String FILENAME = "clothing.json";

    private ArrayList<Clothing> mClothing;
    private ClothingJSONSerializer mSerializer;

    private static Clothing sClothing;
    private Context mAppContext;

    private SaveClothing(Context mAppContext){
        mAppContext = mAppContext;
        mClothing = new ArrayList<Clothing>();
        mSerializer = new ClothingJSONSerializer(mAppContext, FILENAME);

        try{
            mClothing = mSerializer.loadClothing();
        }
        catch (Exception e){
            mClothing = new ArrayList<>(Clothing);
            Log.e(TAG, "Error loading clothing: ", e);
        }
    }

    public void addClothing(Clothing c){
        mClothing.add(c);
    }

    public boolean saveClothing{
        try{
            mSerializer.saveClothing(mClothing);
            Log.d(TAG, "clothing saved to file");
            return true;
        }
        catch (Exception e){
            Log.e(TAG, "Error saving clothing: ", e);
            return false;
        }
    }

}
