package com.example.mothercarereminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mothercarereminder.Model.DatabaseHelper;

public class MotherNoticeActivity extends AppCompatActivity {
    Button submit,show;

    EditText date,body,tittle;
    String Date,Tittle,Body;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_notice);
        body =  findViewById(R.id.body);
        tittle =  findViewById(R.id.tittle);
        date = findViewById(R.id.date);
        submit =  findViewById(R.id.submit);


        submit = (Button) findViewById(R.id.submit);
        databaseHelper = new DatabaseHelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tittle = tittle.getText().toString();
                Body = body.getText().toString();
                Date = date.getText().toString();

                //Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
                if (Tittle.isEmpty() && Body.isEmpty()&& Date.isEmpty()){

                    Toast.makeText(MotherNoticeActivity.this, "please fill details", Toast.LENGTH_SHORT).show();
                }else {
 ////////// this is shown on the screen after data has been entered ///////////////////
                    Toast.makeText(MotherNoticeActivity.this, "Note submitted successful", Toast.LENGTH_SHORT).show();
                    databaseHelper.insertdata(Date,Tittle,Body);
                    tittle.setText("");
                    body.setText("");
                    date.setText("");


                }
            }
        });
    }
}
