package com.example.cidseuser.colorcloset;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

        SharedPreferences mPrefs;
        final String welcomeScreenShownPref = "welcomeScreenShown";

        // Called when the activity is first created.

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

            // second argument is the default to use if the preference can't be found

            Boolean welcomeScreenShown = mPrefs.getBoolean(welcomeScreenShownPref, false);

            if (!welcomeScreenShown) {

                // here you can launch next activity
                // the code below will go to Robin's Title screen

                String whatsNewTitle = getResources().getString(R.string.whatsNewTitle);
                String whatsNewText = getResources().getString(R.string.whatsNewText);
                new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle(whatsNewTitle).setMessage(whatsNewText).setPositiveButton(
                        R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putBoolean(welcomeScreenShownPref, true);
                editor.commit();

                // Very important to save the preference
            }


        }


    }

