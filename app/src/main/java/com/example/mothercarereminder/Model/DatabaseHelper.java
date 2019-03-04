package com.example.mothercarereminder.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static String DATABASE = "database.db";
    public static String TABLE = "noteTabe";
    public static String DATE = "date";
    public static String TITTLE = "tittle";
    public static String BODY = "body";
    String br;

    public DatabaseHelper(Context context) {

        super( context, DATABASE, null, 1 );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //  br= "CREATE TABLE mytable(name TEXT,company TEXT,city TEXT,country TEXT);";
        br = "CREATE TABLE " + TABLE + "(" + DATE + " Text, " + TITTLE + " Text, " + BODY + " Text );";
        db.execSQL( br );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE + " ;" );
    }


    public void insertdata(String date, String tittle, String body) {
        System.out.print( "Hello " + br );
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put( DATE, date );
        contentValues.put( TITTLE, tittle );
        contentValues.put( BODY, body );
        db.insert( TABLE, null, contentValues );


    }

    public List<NoteHelper> getdata() {
        // DataModel dataModel = new DataModel();
        List<NoteHelper> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery( "select * from " + TABLE + " ;", null );
        StringBuffer stringBuffer = new StringBuffer();
        NoteHelper dataModel = null;
        while (cursor.moveToNext()) {
            dataModel = new NoteHelper();
            String date = cursor.getString( cursor.getColumnIndexOrThrow( "date" ) );
            String tittle = cursor.getString( cursor.getColumnIndexOrThrow( "tittle" ) );
            String body = cursor.getString( cursor.getColumnIndexOrThrow( "body" ) );
            dataModel.setDate( date );
            dataModel.setNoteTittle( tittle );
            dataModel.setNoteBoddy( body );
            stringBuffer.append( dataModel );
            // stringBuffer.append(dataModel);
            data.add( dataModel );
        }

        for (NoteHelper mo : data) {

            Log.i( "Helle", "" + mo.getNoteBoddy() );
        }

        //

        return data;
    }

}