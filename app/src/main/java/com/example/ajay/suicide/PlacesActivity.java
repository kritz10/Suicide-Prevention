package com.example.ajay.suicide;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {

    ArrayList<String> place = new ArrayList<String>() ;
    ArrayAdapter<String> adapterp ;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        db=new DataBaseHelper(this);
        Cursor cursor=db.getPlacesContents();
        while(cursor.moveToNext()){
            place.add(cursor.getString(1));
        }

        adapterp = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , place) ;
        ListView listViewp = (ListView) findViewById(R.id.list_place) ;

        Button button = (Button) findViewById(R.id.add_1) ;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                EditText editText = (EditText) findViewById(R.id.edit_text_2) ;
                String s = editText.getText().toString() ;
                if(s.length()!=0) {
                    boolean check=db.addPlaces(s);
                    if(check==true)
                        Toast.makeText(PlacesActivity.this,"Successfully inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(PlacesActivity.this,"Something went wrong!", Toast.LENGTH_LONG).show();
                    editText.setText("");
                }
                else{
                    Toast.makeText(PlacesActivity.this,"Empty text field! Enter text first", Toast.LENGTH_LONG).show();
                }
                place.add(s) ;
                adapterp.notifyDataSetChanged();
                //editText.setText("");
            }
        });
        listViewp.setAdapter(adapterp);

     listViewp.setOnTouchListener(new ListView.OnTouchListener() {
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

    //public void addPlace(View view){

    //}

