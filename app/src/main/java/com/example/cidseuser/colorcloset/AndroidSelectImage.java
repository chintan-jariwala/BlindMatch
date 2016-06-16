package com.example.cidseuser.colorcloset;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

/**
 * Created by Mark on 6/16/2016.
 */

public class AndroidSelectImage extends Activity{
    TextView textTargetUri,tvfinalColor;
    ImageView targetImage;
    Button buttonLoadImage;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library);

        buttonLoadImage = (Button)findViewById(R.id.gallery);
        //textTargetUri = (TextView)findViewById(R.id.targeturi);
        targetImage = (ImageView)findViewById(R.id.targetimage);

        tvfinalColor = (TextView) findViewById(R.id.tvfinalColor);

        buttonLoadImage.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            textTargetUri.setText(targetUri.toString());
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                targetImage.setImageBitmap(bitmap);
                ColorDetection colorDetection = new ColorDetection(bitmap);
                String color = colorDetection.returnColor();
                tvfinalColor.setTextColor(Color.parseColor(color));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
