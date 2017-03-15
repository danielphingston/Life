package com.example.d.life;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}
    public void buttonOnClick(View v){
        Button button=(Button) v;
        startActivity(new Intent(getApplicationContext(),register.class));

    }

    public void Login(View v){
        Button l=(Button) v;
        startActivity(new Intent(getApplicationContext(),Login.class));
    }

    public void Request(View v){
        Button l=(Button) v;
        startActivity(new Intent(getApplicationContext(),Request.class));
    }

    public void Donor(View v){
        Button l=(Button) v;
        startActivity(new Intent(getApplicationContext(),Donors.class));
    }

    public void Donate(View v){
        Button l=(Button) v;
        startActivity(new Intent(getApplicationContext(),donate.class));
    }

    public void faq(View v){
        Button l=(Button) v;
        startActivity(new Intent(getApplicationContext(),FAQ.class));
    }

    public void pd(View v){
        Button l=(Button) v;
        startActivity(new Intent(getApplicationContext(),pd.class));
    }




}

