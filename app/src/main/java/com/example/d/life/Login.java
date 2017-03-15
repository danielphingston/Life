package com.example.d.life;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

       final EditText username = (EditText) findViewById( R.id.username );
        final EditText password = (EditText) findViewById( R.id.password );
       final Button blogin = (Button) findViewById( R.id.blogin );



    }


}


