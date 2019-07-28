package com.example.ajay.suicide;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {


    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    public void submit(View view){
        ed1=(EditText)findViewById(R.id.edit_name);
        ed2=(EditText)findViewById(R.id.edit_age);
        ed3=(EditText)findViewById(R.id.edit_gender);
        ed4=(EditText)findViewById(R.id.edit_email);


        String name=ed1.getText().toString();
        String age=ed2.getText().toString();
        String gender=ed3.getText().toString();
        String email=ed4.getText().toString();


        if(name==null||age==null||gender==null||email==null|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this,"Invalid input",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,Register.class);
            startActivity(i);
        }



        SharedPreferences sharedpreferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreferences.edit();

        editor.putBoolean("registered",true);
        editor.putString("name",name);
        editor.putString("age",age);
        editor.putString("gender",gender);
        editor.putString("email",email);
        editor.commit();
        finish();

        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);



    }
}
