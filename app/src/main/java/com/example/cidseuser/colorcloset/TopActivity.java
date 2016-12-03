package com.example.cidseuser.colorcloset;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Mark on 12/2/2016.
 */
public class TopActivity extends AppCompatActivity {

    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(TopActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        create = (Button) findViewById(R.id.button2);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopActivity.this,
                        CreateTopActivity.class);
                startActivity(intent);
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
                    R.drawable.shirt2,
                    R.drawable.shirt3,
                    R.drawable.shirt,
                    R.drawable.shirt4

            };
        }

    }
