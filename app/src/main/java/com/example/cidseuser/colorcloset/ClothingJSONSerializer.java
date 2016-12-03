package com.example.cidseuser.colorcloset;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;


/**
 * Created by temp6435 on 11/5/2016.
 */
public class ClothingJSONSerializer {

    private Context mContext;
    private String mFilename;

    public ClothingJSONSerializer(Context c, String f){
        mContext = c;
        mFilename = f;
    }

    public void saveClothes(ArrayList<Clothing> clothes)
            throws JSONException, IOException{
        //builds array in JSON
        JSONArray array = new JSONArray();
        for(Clothing c: clothes){

            //TODO: Fix this
            array.put(c.toJSON());
        }

        //write file to disk
        Writer writer = null;
        try {
            OutputStream out = mContext
                    .openFileOutput(mFilename, mContext.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        }
        catch(FileNotFoundException e) {
            Log.e("TAG","file not found");
        }
        catch(IOException e) {
            Log.e("TAG","IOException");
        }
        finally {
            if (writer != null)
                writer.close();
        }
    }

    public ArrayList<Clothing> loadClothes() throws IOException, JSONException{
        ArrayList<Clothing> clothes = new ArrayList<>();
        BufferedReader reader = null;
        try{
            //opens and reads rile into a StringBuilder
            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null){
                //linne breaks are omitted and irrelevant
                jsonString.append(line);
            }

            //Parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString())
                    .nextValue();
            //Build the array of crimes from JSONObjects
            for (int i = 0; i < array.length(); i++){
                clothes.add(new Clothing(array.getJSONObject(i)));
            }
        }
        catch(FileNotFoundException e){
            //Ignore this one; it happens when startinng fresh
        }
        finally{
            if(reader != null)
                reader.close();
        }
        return clothes;
    }



}