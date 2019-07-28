package com.example.ajay.suicide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean registered=false;
        SharedPreferences sharedPreferences=getSharedPreferences("Preferences",MODE_PRIVATE);
        registered=sharedPreferences.getBoolean("registered",false);
        if(registered==false){
            Intent i=new Intent(this,Register.class);
            startActivity(i);
        }

        TextView help = (TextView) findViewById(R.id.button_ask_for_help);
        // Set a click listener on that View
        help.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent helpIntent = new Intent(MainActivity.this, AskForHelpActivity.class);

                // Start the new activity
                startActivity(helpIntent);
                //Toast.makeText(view.getContext(),"Numbers list",Toast.LENGTH_SHORT).show();
            }
        });

        // Find the View that shows the family category
        TextView music = (TextView) findViewById(R.id.button_listen_to_some_music);

        // Set a click listener on that View
        music.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {

                Intent musicIntent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);

                // Start the new activity
                startActivity(musicIntent);
                //Toast.makeText(view.getContext(),"Family list",Toast.LENGTH_SHORT).show();
            }
        });

        // Find the View that shows the colors category
        TextView warning = (TextView) findViewById(R.id.button_warning_signs);

        // Set a click listener on that View
        warning.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {

                Intent warningIntent = new Intent(MainActivity.this, WarningSignsActivity.class);

                // Start the new activity
                startActivity(warningIntent);
                //Toast.makeText(view.getContext(),"Colors list",Toast.LENGTH_SHORT).show();
            }
        });

        // Find the View that shows the phrases category
        TextView reasons = (TextView) findViewById(R.id.button_reasons);

        // Set a click listener on that View
        reasons.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {

                Intent reasonsIntent = new Intent(MainActivity.this, ReasonsActivity.class);

                // Start the new activity
                startActivity(reasonsIntent);
                // Toast.makeText(view.getContext(),"Phrases list",Toast.LENGTH_SHORT).show();
            }
        });

        TextView safety = (TextView) findViewById(R.id.button_safety);

        // Set a click listener on that View
        safety.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {

                Intent safetyIntent = new Intent(MainActivity.this, SafetyActivity.class);

                // Start the new activity
                startActivity(safetyIntent);
                //Toast.makeText(view.getContext(),"Family list",Toast.LENGTH_SHORT).show();
            }
        });

        TextView places = (TextView) findViewById(R.id.button_places);

        // Set a click listener on that View
        places.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {

                Intent placesIntent = new Intent(MainActivity.this, PlacesActivity.class);

                // Start the new activity
                startActivity(placesIntent);
                //Toast.makeText(view.getContext(),"Family list",Toast.LENGTH_SHORT).show();
            }
        });


        TextView profile = (TextView) findViewById(R.id.button_profile);
        // Set a click listener on that View
        profile.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent profileIntent = new Intent(MainActivity.this, Profile.class);

                // Start the new activity
                startActivity(profileIntent);
                //Toast.makeText(view.getContext(),"Numbers list",Toast.LENGTH_SHORT).show();
            }
        });


    }

}


