package com.abia.fellows.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.abia.fellows.R;

public class MainActivity extends AppCompatActivity {
   // private TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setContentView(R.layout.register);
      //  textView1 = findViewById(R.id.notregistered);
        //textView1.setOnClickListener(new View.OnClickListener() {
           // @Override

        findViewById(R.id.notregistered).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });


            }
        }



