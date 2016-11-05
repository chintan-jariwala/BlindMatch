package com.example.cidseuser.colorcloset;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileNotFoundException;
import java.io.IOException;
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

    public void saveClothing(ArrayList<Clothing> clothing)
        throws JSONException, IOException{
            //builds array in JSON
            JSONArray array = new JSONArray();
            for(Clothing c: clothing){
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
}

