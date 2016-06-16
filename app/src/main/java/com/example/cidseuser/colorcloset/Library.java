package com.example.cidseuser.colorcloset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

public class Library extends AppCompatActivity {

    Button tops;
    Button back_to_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library);

        tops = (Button) findViewById(R.id.button);
        tops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Library.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });

        back_to_camera = (Button) findViewById(R.id.back_to_camera);
        back_to_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Library.this,
                        CameraHome.class);
                startActivity(intent);
            }
        });


        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Library.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbIds[position]);
            return imageView;

        }

        private Integer[] mThumbIds = {

                R.drawable.shorts,
                R.drawable.shorts2,
                R.drawable.shorts3,
                R.drawable.pants,
                R.drawable.pants2,
                R.drawable.skirt,
                R.drawable.skirt2
        };}
}


