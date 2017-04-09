package com.example.d.life;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class notify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        String not11;

        final TextView not1 = (TextView) findViewById(R.id.not1);

        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        not11 = loginData.getString("notify", null);

        not1.setText(not11);

    }
    public void userpro(View v) {
               startActivity(new Intent(getApplicationContext(), userprofile.class));

    }
}
