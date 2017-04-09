package com.example.d.life;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Request extends AppCompatActivity {
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_request );

        Intent intent = getIntent();
        username = intent.getStringExtra( "username" );
        final Spinner sorgan = (Spinner) findViewById( R.id.sorgan );
        final Spinner sblood = (Spinner) findViewById( R.id.sblood );
        final EditText scontact = (EditText) findViewById( R.id.scontact );
        final EditText sage = (EditText) findViewById( R.id.sage );
        final EditText sreason = (EditText) findViewById( R.id.sreason );
        final Spinner sstate = (Spinner) findViewById( R.id.sstate );
        final EditText scity = (EditText) findViewById( R.id.scity );
        final Button brequest = (Button) findViewById( R.id.brequest );



        brequest.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (sage.length() <= 0) {
                    sage.setError("cannot be empty");
                } else if (scontact.length() != 10) {
                    scontact.setError("invalid number");
                } else {
                    final String organ = sorgan.getSelectedItem().toString();
                    final String blood = sblood.getSelectedItem().toString();
                    final String contact = scontact.getText().toString();
                    final int age = Integer.parseInt(sage.getText().toString());
                    final String reason = sreason.getText().toString();
                    final String state = sstate.getSelectedItem().toString();
                    final String city = scity.getText().toString();


                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                boolean exist =jsonResponse.getBoolean("exist");

                                if (success) {
                                    Toast.makeText(getApplicationContext(), "Request Submitted", Toast.LENGTH_LONG).show();
                                    finish();

                                } else {
                                    if(exist)
                                    {AlertDialog.Builder builder = new AlertDialog.Builder(Request.this);
                                        builder.setMessage(" only  1 entry per user ")
                                                .setNegativeButton("ok", null)
                                                .create()
                                                .show();}

                                    AlertDialog.Builder builder = new AlertDialog.Builder(Request.this);
                                    builder.setMessage("Update failed")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    };


                    RequestRequest requestRequest = new RequestRequest(organ, blood, contact, age, state, city, reason, username, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(Request.this);
                    queue.add(requestRequest);


                }
            }
                                     }
        );

    }
}
