package com.example.d.life;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class userprofile extends AppCompatActivity {




    String username;
    String password;
    String location;
    String name;
    String email;
    String contact;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        final TextView usernames = (TextView) findViewById(R.id.user_username);
        final TextView locations = (TextView) findViewById(R.id.user_location);
        final TextView contacts = (TextView) findViewById(R.id.user_contact);
        final TextView names = (TextView) findViewById(R.id.user_name);
        final TextView emails = (TextView) findViewById(R.id.user_email);


        username = getIntent().getStringExtra("username");
        location = getIntent().getStringExtra("location");
        contact = getIntent().getStringExtra("contact");
        email = getIntent().getStringExtra("email");
        name = getIntent().getStringExtra("name");


        usernames.setText(username);
        names.setText(name);
        emails.setText(email);
        locations.setText(location);
        contacts.setText(contact);
        names.setText(name);



    }




}
