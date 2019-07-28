package com.example.ajay.suicide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="suicide.db";
    public static final String REASONS_TABLE="Reasons";
    public static final String PLACES_TABLE="Places";
    public static final String Col_id="ID";
    public static final String Col_content="ITEM";


    public DataBaseHelper(Context context){

        super(context,DATABASE_NAME,null,1);
    }

    public void onCreate(SQLiteDatabase db) {
        String createTable1="CREATE TABLE "+REASONS_TABLE+" (Col_id INTEGER PRIMARY KEY AUTOINCREMENT, "+ " ITEM TEXT)";
        String createTable2="CREATE TABLE "+PLACES_TABLE+" (Col_id INTEGER PRIMARY KEY AUTOINCREMENT, "+ " ITEM TEXT)";
        db.execSQL(createTable1);
        db.execSQL(createTable2);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ REASONS_TABLE);
        db.execSQL(" DROP TABLE IF EXISTS "+ PLACES_TABLE);
        //onCreate(db);

    }
    public boolean addReasons(String item){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_content,item);
        long result=db.insert(REASONS_TABLE,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;


    }

    public Cursor getReasonsContents(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+REASONS_TABLE,null);
        return cursor;

    }
    public boolean addPlaces(String item){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_content,item);
        long result=db.insert(PLACES_TABLE,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;


    }

    public Cursor getPlacesContents(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+PLACES_TABLE,null);
        return cursor;

    }


}