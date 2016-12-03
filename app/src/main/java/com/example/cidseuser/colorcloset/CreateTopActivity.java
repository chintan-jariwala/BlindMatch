package com.example.cidseuser.colorcloset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    @Override
    public View findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createtop);
        //SaveButton = (Button)findViewById(R.id.button);
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
}
