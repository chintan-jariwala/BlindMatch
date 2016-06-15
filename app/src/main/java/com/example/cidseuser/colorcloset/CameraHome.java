package com.example.cidseuser.colorcloset;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CameraHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_home);
    }

    public void cameraClicked (View view) {
        Intent intent =new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
}
