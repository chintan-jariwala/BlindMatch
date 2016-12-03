package com.example.cidseuser.colorcloset;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Mark on 12/1/2016.
 */
public class CreateTopActivity extends AppCompatActivity {

    EditText DescriptionEditText;
    TextView textViewDescription;
    Button SaveButton;
    private Button mNewTop;
    private Button mNewBottom;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button picture;


    @Override
    public View findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createtop);
        picture = (Button)findViewById(R.id.pictureButton);
        picture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
        //DescriptionEditText = (EditText)findViewById(R.id.editDescription);

        //mNewTop = (Button)findViewById(R.id.menu_item_new_top);
/*        mNewTop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(CreateTopActivity.this, CreateTopActivity.class);
                startActivity(i);
            }
        });*/
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}
