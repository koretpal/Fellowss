package com.abia.fellows.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.abia.fellows.R;
import com.abia.fellows.adapter.ContactHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactDetailsActivity extends AppCompatActivity {
    ContactHelper helper;
    ListView list;
    ListAdapter adapter;
    private Button btnback;
    private String btback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);


         helper = new ContactHelper(getApplicationContext());
        ArrayList<HashMap<String, String>> userList = helper.getUsers();
        list = findViewById(R.id.listview);
        adapter = new SimpleAdapter(ContactDetailsActivity.this, userList, R.layout.contacts_layouts, new String[] {"fullname", "phone"
        ,"email", "gender", "state"}, new int [] {R.id.tvname, R.id.tvphonenumber, R.id.tvemail, R.id.tvgender, R.id.tvstate} );

        list.setAdapter(adapter);


        btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactDetailsActivity.this, RegisterActivity.class));
            }
        });
    }


}
