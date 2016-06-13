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
import java.lang.Boolean;
import java.lang.*;

public class Clothing {

    public String hexvalue;
    public Boolean pattern;

    public Clothing(String hvalue, Boolean pat){
        hexvalue = hvalue;
        pattern = pat;
    }

    public interface top{
    }

    public interface bottom{
    }

    public interface outer{
    }

    private ArrayList<shirt> shirt;
    private ArrayList<cShirt> cShirt;
    private ArrayList<sweater> sweater;
    private ArrayList<jacket> jacket;
    private ArrayList<bottom> bottom;
    private ArrayList<other> other;
    private ArrayList<dress> dress;

    public Clothing(ArrayList<shirt>shirt, ArrayList<cShirt> cShirt, ArrayList<sweater> sweater, ArrayList<jacket> jacket, ArrayList<bottom> bottom, ArrayList<other> other, ArrayList<dress> dress){
        this.shirt = shirt;
        this.cShirt = cShirt;
        this.sweater = sweater;
        this.jacket = jacket;
        this.bottom = bottom;
        this.other = other;
        this.dress = dress;
    }

    public class shirt extends Clothing {
        //Here the code will check the hex value and categorize it in one color:
        public shirt(String hvalue, Boolean pat){
            super(hvalue, pat);
        }
    }

    public class cShirt extends Clothing {
        public cShirt(String hvalue, Boolean pat){
            super(hvalue, pat);
        }
    }

    public class sweater extends Clothing {
        public sweater(String hvalue, Boolean pat){
            super(hvalue, pat);
        }
    }

    public class jacket extends Clothing {
        public jacket(String hvalue, Boolean pat){
            super(hvalue, pat);
        }
    }

    public class bottom extends Clothing {
        public bottom(String hvalue, Boolean pat){
            super(hvalue, pat);
        }
    }

    public class other extends Clothing {
        public other(String hvalue, Boolean pat){
            super(hvalue, pat);
        }
    }

    public class dress extends Clothing {
        public dress(String hvalue, Boolean pat){
            super(hvalue, pat);
        }
    }

}
