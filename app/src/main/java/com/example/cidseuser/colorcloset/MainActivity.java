//package com.example.mark.myapplication;
package com.example.cidseuser.colorcloset;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

////import com.example.mark.myapplication.R;
//import com.example.cidseuser.colorcloset.R;
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;

            //test test
    Button bottoms;
    private View imgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgPicture = findViewById(R.id.gridView);
        bottoms = (Button) findViewById(R.id.button2);
        bottoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(intent);
            }
        });

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        loadImageFromStorage();
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //test getComplementaryColor method
        //int test = Outfit.getComplementaryColor(Color.CYAN);
        //Log.e("MainActivity", "result " + test);
        // run unit tests
        //GetComplementaryColor_of_White_Returns_Black();

        //Calling_Filter_On_Outfit_With_Black_Top_Results_In_White_Bottoms();
        //Calling_Filter_On_Outfit_With_Cyan_Top_Results_In_Red_Bottoms();
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount () {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position){
            return 0;
        }

        public View getView (int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbIds[position]);
            return imageView;

        }
        private Integer [] mThumbIds = {
                R.drawable.shirt2,
                R.drawable.shirt3,
                R.drawable.shirt,
                R.drawable.shirt4

        };
    }

    protected Wardrobe CreateWardrobe() {
        List<Clothing> tops = new ArrayList<Clothing>();
        List<Clothing> bottoms = new ArrayList<Clothing>();
        tops.add(new Clothing(Color.BLACK, new String[]{"t-shirt"}, "short-sleeve t-shirt"));
        tops.add(new Clothing(Color.CYAN, new String[]{"t-shirt"}, "short-sleeve t-shirt"));
        tops.add(new Clothing(Color.MAGENTA, new String[]{"t-shirt"}, "short-sleeve t-shirt"));
        tops.add(new Clothing(Color.YELLOW, new String[]{"t-shirt"}, "short-sleeve t-shirt"));
        tops.add(new Clothing(Color.BLACK, new String[]{"shirt"}, "long-sleeve t-shirt"));

        bottoms.add(new Clothing(Color.WHITE, new String[]{"shorts"}, "cargo shorts"));
        bottoms.add(new Clothing(Color.RED, new String[]{"shorts"}, "cargo shorts"));
        bottoms.add(new Clothing(Color.GREEN, new String[]{"shorts"}, "cargo shorts"));
        bottoms.add(new Clothing(Color.BLUE, new String[]{"shorts"}, "cargo shorts"));
        bottoms.add(new Clothing(Color.WHITE, new String[]{"pants"}, "skinny jeans"));

        Wardrobe myClothes = new Wardrobe();

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

    /*protected void Match_Top(){
        Wardrobe clothes = CreateWardrobe();
        Outfit outfit = new Outfit();
        //Top shirt =
    }*/

    protected void GetComplementaryColor_of_White_Returns_Black() {
        Log.e("Black = {0}", Integer.toString(Color.BLACK));
        assertEquals(Color.WHITE, Outfit.getComplementaryColor(Color.BLACK));
    }

    protected void Calling_Filter_On_Outfit_With_Black_Top_Results_In_White_Bottoms() {
        Wardrobe clothes = CreateWardrobe();
        Outfit outfit = new Outfit();
        Clothing shirt = new Clothing(Color.BLACK, null, null);
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
        Clothing shirt = new Clothing(Color.CYAN, null, null);
        outfit.setTop(shirt);
        List<Clothing> filteredBottoms = outfit.Filter(clothes.getBottoms());
        assertNotNull(filteredBottoms);
        assertEquals(1, filteredBottoms.size());
        assertEquals(Color.RED, filteredBottoms.get(0).getColor());
    }

    @Override
    public void onStart() {
        super.onStart();

//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.mark.myapplication/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);

    }

    @Override
    public void onStop() {
        super.onStop();

//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.mark.myapplication/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
    }

    //TODO: ask mentor how to set  up a unit test project and how to use it to run tests

    /*public void onImageGalleryClicked(View v){
        Intent photoPickerIntent
    }*/

//    @Override
//    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
//        super.startActivityForResult(intent, requestCode, options);
//        startActivityForResult();
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        if(resultCode == RESULT_OK){
//            if(requestCode == IMAGE_GALLERY_REQUEST){
//
//            }
//        }
//    }

    private void loadImageFromStorage()
    {

        try {
            File f=new File("/storage/emulated/0/Android/data/com.example.cidseuser.colorcloset/files/", "pic.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            //ImageView img=(ImageView)findViewById(R.id.imageView);
            //img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(getActivity());
                return true;
            case R.id.menu_item_save_clothes:
                Toast.makeText(this, "Save Clothes is Selected", Toast.LENGTH_SHORT).show();

                Wardrobe wardrobe = Wardrobe.get(getApplicationContext());
                wardrobe.save();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        //SaveClothing.get(getActivity()).saveClothing();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}

