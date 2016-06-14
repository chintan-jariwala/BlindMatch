package com.example.mark.myapplication;

import android.graphics.Color;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mark.myapplication.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.*;
import static junit.framework.Assert.*;


public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        Log.e("hello", "hello");

        // run unit tests
        //GetComplementaryColor_of_White_Returns_Black();

        //Calling_Filter_On_Outfit_With_Black_Top_Results_In_White_Bottoms();
        //Calling_Filter_On_Outfit_With_Cyan_Top_Results_In_Red_Bottoms();
    }

    protected Wardrobe CreateWardrobe() {
        List<Clothing> tops = new ArrayList<Clothing>();
        List<Clothing> bottoms = new ArrayList<Clothing>();
        tops.add(new Top(Color.BLACK, new String[]{"t-shirt"}, "short-sleeve t-shirt"));
        tops.add(new Top(Color.CYAN, new String[]{"t-shirt"}, "short-sleeve t-shirt"));
        tops.add(new Top(Color.MAGENTA, new String[]{"t-shirt"}, "short-sleeve t-shirt"));
        tops.add(new Top(Color.YELLOW, new String[]{"t-shirt"}, "short-sleeve t-shirt"));
        tops.add(new Top(Color.BLACK, new String[]{"shirt"}, "long-sleeve t-shirt"));

        bottoms.add(new Bottom(Color.WHITE, new String[]{"shorts"}, "cargo shorts"));
        bottoms.add(new Bottom(Color.RED, new String[]{"shorts"}, "cargo shorts"));
        bottoms.add(new Bottom(Color.GREEN, new String[]{"shorts"}, "cargo shorts"));
        bottoms.add(new Bottom(Color.BLUE, new String[]{"shorts"}, "cargo shorts"));
        bottoms.add(new Bottom(Color.WHITE, new String[]{"pants"}, "skinny jeans"));

        Wardrobe myClothes = new Wardrobe(tops, bottoms);

        return myClothes;


        //List<Clothing> test = Filter(myClothes);

        /*public String toString(){
            String test = tops.toString();

        }*/

        /*
        for (Top t : tops) {
            tops.add(t.toString());
            return tops;
        }
        */

        //String TAG = "MainActivity";
        //Log.e(TAG, test);
    }

    protected void GetComplementaryColor_of_White_Returns_Black()
    {
        Log.e("Black = {0}", Integer.toString(Color.BLACK));
        assertEquals(Color.WHITE, Outfit.getComplementaryColor(Color.BLACK));
    }

    protected void Calling_Filter_On_Outfit_With_Black_Top_Results_In_White_Bottoms() {
        Wardrobe clothes = CreateWardrobe();
        Outfit outfit = new Outfit();
        Top shirt = new Top(Color.BLACK, null, null);
        outfit.setTop(shirt);
        List<Clothing> filteredBottoms = outfit.Filter(clothes.getBottoms());
        assertNotNull(filteredBottoms);
        assertEquals(2, filteredBottoms.size());
        for(Clothing c : filteredBottoms){
            assertEquals(Color.WHITE, c.getColor());
        }
    }

    protected void Calling_Filter_On_Outfit_With_Cyan_Top_Results_In_Red_Bottoms() {
        Wardrobe clothes = CreateWardrobe();
        Outfit outfit = new Outfit();
        Top shirt = new Top(Color.CYAN, null, null);
        outfit.setTop(shirt);
        List<Clothing> filteredBottoms = outfit.Filter(clothes.getBottoms());
        assertNotNull(filteredBottoms);
        assertEquals(1, filteredBottoms.size());
        assertEquals(Color.RED, filteredBottoms.get(0).getColor());
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.mark.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);

    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.mark.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    //TODO: ask mentor how to set  up a unit test project and how to use it to run tests
}


