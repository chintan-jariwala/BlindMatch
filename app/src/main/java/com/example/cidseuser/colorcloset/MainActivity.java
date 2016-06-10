package com.example.cidseuser.colorcloset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}


package com.example.cidseuser.colorcloset;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by cidseuser on 6/10/2016.
 */
public class Clothing {

    private String hexvalue;


    public class shirt extends Clothing {
        public shirt(String hvalue){

        }
    }

    public class cShirt extends Clothing {
        public cShirt(String hvalue){

        }
    }

    public class sweater extends Clothing {
        public sweater(String hvalue){

        }

    }

    public class jacket extends Clothing {
        public jacket(String hvalue){

        }

    }

    public class bottom extends Clothing {
        public bottom(String hvalue){

        }

    }

    public class other extends Clothing {
        public other(String hvalue){

        }

    }

    public class dress extends Clothing {
        public dress(String hvalue){

        }

    }

}
