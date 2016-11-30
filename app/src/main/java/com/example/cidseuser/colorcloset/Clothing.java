package com.example.cidseuser.colorcloset;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by cidseuser on 6/14/2016.
 */
public class Clothing {

    //region MEMBERS
    private static final String JSON_ID = "id";
    private static final String JSON_COLOR = "color";
    private static final String JSON_PHOTOFILEPATH = "photofilepath";

    private UUID id;
    private int color;
    private String photofilepath;
    //endregion

    //region CONSTRUCTORS
    public Clothing(int rgb, String[] tags, String description) {
        int RGB = -1;
        String Color = Integer.toString(RGB);
    }

    public Clothing(JSONObject json) throws JSONException {
        id = UUID.fromString(json.getString(JSON_ID));
        color = json.getInt(JSON_COLOR);
        photofilepath = json.getString(JSON_PHOTOFILEPATH);
    }
    //endregion

    //region PUBLIC METHODS
    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, id.toString());
        json.put(JSON_COLOR, color);
        json.put(JSON_PHOTOFILEPATH, photofilepath);
        return json;
    }

    public String getPhotofilepath(){
        return photofilepath;
    }

    public UUID getId(){
        return id;
    }

    public int getColor(){ return color; }
    //endregion
}
