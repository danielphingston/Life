package com.example.d.life;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Request extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_request );

        final Spinner sorgan = (Spinner) findViewById( R.id.sorgan );
        final Spinner sblood = (Spinner) findViewById( R.id.sblood );
        final EditText scontact = (EditText) findViewById( R.id.scontact );
        final EditText sage = (EditText) findViewById( R.id.sage );
        final EditText sreason = (EditText) findViewById( R.id.sreason );
        final Button brequest = (Button) findViewById( R.id.brequest );


        brequest.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String organ = sorgan.getSelectedItem().toString();
                final String blood = sblood.getSelectedItem().toString();
                final String contact = scontact.getText().toString();
                final int age = Integer.parseInt(sage.getText().toString());
                final String reason = sreason.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject( response );
                            boolean success = jsonResponse.getBoolean( "success" );

                            if (success) {
                                Intent intent = new Intent( Request.this, MainActivity.class );
                                Request.this.startActivity( intent );
                                finish();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder( Request.this );
                                builder.setMessage( "Update failed" )
                                        .setNegativeButton( "Retry", null )
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };


               RequestRequest requestRequest= new RequestRequest( organ, blood, contact, age, reason, responseListener );
                RequestQueue queue = Volley.newRequestQueue( Request.this );
                queue.add( requestRequest );


            }
                                     }
        );

    }
}
