package com.example.cidseuser.colorcloset;
import android.graphics.Color;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.lang.*;
import java.util.UUID;

/**
 * Created by cidseuser on 6/14/2016.
 */
public class Clothing {
    public Clothing(int rgb, String[] tags, String description) {
        color = rgb;
    }

    private static final String JSON_ID = "id";
    private static final String JSON_COLOR = "color";
    private static final String JSON_PHOTOFILEPATH = "photofilepath";

    private List<Top> tops;
    private List<Bottom> bottoms;
    private UUID id;
    private String color;
    private String photofilepath;

    /*private String color;
    private String photofilepath;
    private int id;*/

    public String getColor(){
        return color;
    }

    public String getPhotofilepath(){
        return photofilepath;
    }

    public UUID getId(){
        return id;
    }

    public Clothing(){
        id = UUID.randomUUID();
    }

    public JSONObject toJSON() throws JSONException{
        JSONObject json = new JSONObject();
        json.put(JSON_ID, id.toString());
        json.put(JSON_COLOR, color.toString());
        json.put(JSON_PHOTOFILEPATH, photofilepath.toString());
        return json;
    }

    public Clothing(JSONObject json) throws JSONException{
        id = UUID.fromString(json.getString(JSON_ID));
        if(json.has(JSON_COLOR)){
            color = json.getString(JSON_COLOR);
        }
        if(json.has(JSON_PHOTOFILEPATH)){
            color = json.getString(JSON_PHOTOFILEPATH);
        }
    }
}
