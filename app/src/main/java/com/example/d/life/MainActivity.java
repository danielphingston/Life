package com.example.d.life;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView etusername = (TextView) findViewById(R.id.etusername);
        etusername.setVisibility(View.GONE);
        Button request = (Button) findViewById((R.id.request));
        request.setVisibility(View.GONE);


        Button login = (Button) findViewById(R.id.login);
        Button logout = (Button) findViewById(R.id.logout);
        Button register = (Button) findViewById(R.id.register);


        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        username = loginData.getString("username", null);

        if (username != null) {
            etusername.setVisibility(View.VISIBLE);
            login.setVisibility(View.GONE);
            logout.setVisibility(View.VISIBLE);
            register.setVisibility(View.GONE);
            request.setVisibility(View.VISIBLE);


        }

        String message = username;
        etusername.setText(message);

    }

    public void Logout(View v) {
        finish();
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginData.edit();
        editor.putString("username", null);
        editor.apply();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));


    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;
        Intent intent = new Intent(this, register.class);
        startActivity(intent);

    }

    public void Login(View v) {
        Button l = (Button) v;
        startActivity(new Intent(getApplicationContext(), Login.class));

    }

    public void Request(View v) {
        Intent intent = new Intent(MainActivity.this, Request.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public void Donor(View v) {
        Button l = (Button) v;
        startActivity(new Intent(getApplicationContext(), Donors.class));

    }

    public void Donate(View v) {
        Button l = (Button) v;
        startActivity(new Intent(getApplicationContext(), donate.class));
    }

    public void faq(View v) {
        Button l = (Button) v;
        startActivity(new Intent(getApplicationContext(), FAQ.class));
    }

    public void pd(View v) {
        Button l = (Button) v;
        startActivity(new Intent(getApplicationContext(), pd.class));
    }

    public void notify(View v){
        startActivity(new Intent(getApplicationContext(), notify.class));

    }


}



