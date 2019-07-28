package com.example.ajay.suicide;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        TextView display_name=(TextView)findViewById(R.id.name);
        TextView display_age=(TextView)findViewById(R.id.age);
        TextView display_gender=(TextView)findViewById(R.id.gender);
        TextView display_email=(TextView)findViewById(R.id.email);

        SharedPreferences sharedPreferences=getSharedPreferences("Preferences",MODE_PRIVATE);

        display_name.setText(sharedPreferences.getString("name"," "));
        display_age.setText(sharedPreferences.getString("age"," "));
        display_gender.setText(sharedPreferences.getString("gender"," "));
        display_email.setText(sharedPreferences.getString("email"," "));



    }
}
