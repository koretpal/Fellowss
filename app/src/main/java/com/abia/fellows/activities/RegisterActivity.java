package com.abia.fellows.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.abia.fellows.R;
import com.abia.fellows.adapter.ContactHelper;

public class RegisterActivity extends AppCompatActivity {

    private  EditText etfname, etlname, etemail, etphone;

            private Spinner spstates, spgender;
           // private RadioButton rmale, rfemale;
            private Button bregister;
            private String fullname, email, state, gender,phone, fname, lname;
            private Boolean male, female;

            private TextView fullnamengender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //instantiating widgets

        etfname = (EditText) findViewById(R.id.etfname);
        etlname = findViewById(R.id.etlname);
        etemail = findViewById(R.id.etemail);
        etphone = findViewById(R.id.etphone);
        spgender = findViewById(R.id.spgender);
        spstates = findViewById(R.id.spstates);
        //rmale = findViewById(R.id.rmale);
        //rfemale = findViewById(R.id.rfemale);
        bregister = findViewById(R.id.bregister);
        //fullnamengender = findViewById(R.id.fullnamengender);




        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process();
            }
        });


        }


    private void process() {

        //type casting
        fname = etfname.getText().toString().trim();
        lname = etlname.getText().toString().trim();
        fullname = fname + " " + lname;
        email = etemail.getText().toString().trim();
        phone = etphone.getText().toString().trim();
        state = spstates.getSelectedItem().toString();
        gender = spgender.getSelectedItem().toString();


        //  rfemale.setChecked(false);


        //validating input fields
        if (fname.isEmpty()) {
            etfname.setError("Please enter your first name");
            Toast.makeText(getApplicationContext(), "please enter your first name", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(lname)) {
            etlname.setError("Please enter your last name");
        } else if (TextUtils.isEmpty(email)) {
            etlname.setError("Please enter your email");
        } else if (TextUtils.isEmpty(phone) || !phone.startsWith("0") || phone.length() < 11) {
            etphone.setError("Please enter a valid phone number");
        } else if (gender.equalsIgnoreCase("Select Gender")) {
            Toast.makeText(getApplicationContext(), "Please select your gender", Toast.LENGTH_LONG).show();
        } else if (state.equalsIgnoreCase("Select state")) {
            Toast.makeText(getApplicationContext(), "Please select your state",
                    Toast.LENGTH_LONG).show();
        }
        // else if(!rfemale.isChecked() && !rmale.isChecked()) {
        // Toast.makeText(getApplicationContext(), "Please select your gender",Toast.LENGTH_LONG).show();
        //  }
        else {
            ContactHelper helper = new ContactHelper(getApplicationContext());
            helper.insertUserDetails(fullname, phone, email, gender, state);
            Toast.makeText(getApplicationContext(), "Data entered successfully", Toast.LENGTH_LONG).show();
            startActivity(new Intent(RegisterActivity.this, ContactDetailsActivity.class));
          // Intent intent = new Intent(RegisterActivity.this, ContactDetailsActivity.class);
            //startActivity(intent);
        }



      /*  fullnamengender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        ContactHelper helper = new ContactHelper(getApplicationContext());
        helper.
        }

        } */


    }


            }



