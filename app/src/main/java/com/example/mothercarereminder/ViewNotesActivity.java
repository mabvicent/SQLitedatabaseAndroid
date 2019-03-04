package com.example.mothercarereminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mothercarereminder.Model.DatabaseHelper;
import com.example.mothercarereminder.Model.NoteHelper;
import com.example.mothercarereminder.Model.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewNotesActivity extends AppCompatActivity {

    Button show;
    DatabaseHelper database;
    RecyclerView recyclerView;
    RecyclerAdapter recycler;
    List<NoteHelper> mydata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_view_notes );
        show =  findViewById( R.id.view );
        mydata = new ArrayList<NoteHelper>();
        recyclerView =  findViewById( R.id.Myrecycle );


        show.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = new DatabaseHelper( ViewNotesActivity.this );
                mydata = database.getdata();
                recycler = new RecyclerAdapter( mydata );


                Log.i( "View notes", "" + mydata );
                RecyclerView.LayoutManager reLayoutManager = new LinearLayoutManager( getApplicationContext() );
                recyclerView.setLayoutManager( reLayoutManager );
                recyclerView.setItemAnimator( new DefaultItemAnimator() );
                recyclerView.setAdapter( recycler );


            }
        } );

    }
}

