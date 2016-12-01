package com.example.cidseuser.colorcloset;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText DescriptionEditText;
    TextView textViewDescription;
    Button SaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SaveButton = (Button)findViewById(R.id.button);
        DescriptionEditText = (EditText)findViewById(R.id.editDescription);
        //SaveButton.setOnClickListener(new View.OnClickListener);
    }

    /*@Override
    public View onCreateView()

    public void onClick(View view){
        final String Name = DescriptionEditText.getText().toString();
    }*/


}
