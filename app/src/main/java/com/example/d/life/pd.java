package com.example.d.life;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class pd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pd );

        final Spinner etorgan = (Spinner) findViewById(R.id.organ1);
        final Spinner etblood1 = (Spinner) findViewById(R.id.blood1);
        final Spinner etblood2 = (Spinner) findViewById(R.id.blood2);
        final Button bbutton = (Button) findViewById(R.id.bbutton);

        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        final String username = loginData.getString("username", null);


        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String organ = etorgan.getSelectedItem().toString();
                final String blood1 = etblood1.getSelectedItem().toString();
                final String blood2 = etblood2.getSelectedItem().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(pd.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                pd.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(pd.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                PdRequest pdRequest = new PdRequest(username,organ,blood1,blood2,responseListener);
                RequestQueue queue = Volley.newRequestQueue(pd.this);
                queue.add(pdRequest);
            }
        });
    }
}