package com.example.ajay.suicide;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReasonsActivity extends AppCompatActivity {
    ArrayList<String> reason = new ArrayList<String>() ;
    ArrayAdapter<String> adapter ;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reasons);
         db=new DataBaseHelper(this);
        Cursor cursor=db.getReasonsContents();
        while(cursor.moveToNext()){
            reason.add(cursor.getString(1));
        }

        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , reason) ;
        ListView listView = (ListView) findViewById(R.id.list_reason) ;

        Button button = (Button) findViewById(R.id.add) ;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                EditText editText = (EditText) findViewById(R.id.edit_text_1) ;
                String s = editText.getText().toString() ;
                if(s.length()!=0) {
                    boolean check=db.addReasons(s);
                    if(check==true)
                        Toast.makeText(ReasonsActivity.this,"Successfully inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(ReasonsActivity.this,"Something went wrong!", Toast.LENGTH_LONG).show();
                         editText.setText("");
                }
                else{
                    Toast.makeText(ReasonsActivity.this,"Empty text field! Enter text first", Toast.LENGTH_LONG).show();
                }

                reason.add(s) ;
                adapter.notifyDataSetChanged();

            }
        });


        listView.setAdapter(adapter);
        listView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });
    }
    }

