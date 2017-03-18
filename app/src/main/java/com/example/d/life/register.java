package com.example.d.life;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        final ProgressBar progress= (ProgressBar) findViewById( R.id.p1 );
        final EditText etusername = (EditText) findViewById( R.id.etusername );
        final EditText etpassword = (EditText) findViewById( R.id.etpassword );
        final Button bregister = (Button) findViewById( R.id.bregister );

        bregister.setOnClickListener( new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              progress.setVisibility(View.VISIBLE );
                                              bregister.setVisibility( View.GONE );

                                              final String username = etusername.getText().toString();
                                              final String password = etpassword.getText().toString();

                                              Response.Listener<String> responseListener = new Response.Listener<String>() {
                                                  @Override
                                                  public void onResponse(String response) {
                                                      try {
                                                          JSONObject jsonResponse = new JSONObject( response );
                                                          boolean success = jsonResponse.getBoolean( "success" );

                                                          if (success) {
                                                              Intent intent = new Intent( register.this, MainActivity.class );
                                                              intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                                                              register.this.startActivity( intent );
                                                              Toast.makeText( getApplicationContext(),"Register Successful",Toast.LENGTH_SHORT ).show();


                                                          } else {
                                                              AlertDialog.Builder builder = new AlertDialog.Builder( register.this );
                                                              builder.setMessage( "Register failed" )
                                                                      .setNegativeButton( "Retry", null )
                                                                      .create()
                                                                      .show();
                                                          }


                                                      } catch (JSONException e) {
                                                          e.printStackTrace();
                                                      }

                                                  }

                                              };


                                              RegisterRequest registerRequest = new RegisterRequest( username, password, responseListener );
                                              RequestQueue queue = Volley.newRequestQueue( register.this );
                                              queue.add( registerRequest );

                                          }
                                      }
        );

    }
}


