package com.example.d.life;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final TextView etusername = (TextView) findViewById( R.id.etusername );
       etusername.setVisibility( View.GONE );
       Button login = (Button) findViewById( R.id.login );

       Intent intent = getIntent();
       String username = intent.getStringExtra( "username" );
       String password = intent.getStringExtra( "password" );
       if(username!=null){
           etusername.setVisibility( View.VISIBLE );
           login.setVisibility( View.GONE );
       }

       String message = "welcome "+username;
       etusername.setText(message);

       }
    public void buttonOnClick(View v){
        Button button=(Button) v;
        Intent intent = new Intent(this, register.class);
        startActivity(intent);

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

