package com.example.mothercarereminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 /////////////////NALUBEGA JUDITH///////////////////
        ////////2017/BIT/171....................

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.addnote){
            Intent intent = new Intent( MainActivity.this,MotherNoticeActivity.class );
            startActivity(intent);

        }
        if(id == R.id.viewnotes){
            Intent intent = new Intent( MainActivity.this,ViewNotesActivity.class );
            startActivity(intent);

        }
        if(id == R.id.profile){
            Intent intent = new Intent( MainActivity.this,MyProfileActivity.class );
            startActivity(intent);

        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "ACTIVITY HAS STARTED", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "ACTIVITY STOPPED", Toast.LENGTH_SHORT).show();
    }
}
