package com.example.d.life;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class verify extends AppCompatActivity implements View.OnClickListener {

    public String JSON_URL;


    private Button verify;
    private Button delete;
    private Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        String x= getIntent().getStringExtra("verify");




        verify = (Button) findViewById(R.id.v_verify);
        verify.setOnClickListener(this);

        delete = (Button) findViewById(R.id.v_delete);
        delete.setOnClickListener(this);

        change = (Button) findViewById(R.id.v_change);
        change.setOnClickListener(this);

        switch(x)
        {
            case "verify":
                delete.setVisibility(View.GONE);
                change.setVisibility(View.GONE);
                findViewById(R.id.v_password).setVisibility(View.GONE);
                break;
            case "delete":
                verify.setVisibility(View.GONE);
                change.setVisibility(View.GONE);
                findViewById(R.id.v_password).setVisibility(View.GONE);
                break;
            case "change":
                verify.setVisibility(View.GONE);
                delete.setVisibility(View.GONE);
                break;

        }

    }

    private void sendRequest() {

        final EditText username1 = (EditText) findViewById(R.id.v_name);
        final EditText password1 = (EditText) findViewById(R.id.v_password);


        final String username = username1.getText().toString();
        final String password = password1.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    Toast.makeText(getApplicationContext(), "Operation Success ", Toast.LENGTH_SHORT).show();

                    if (success) {

                        Toast.makeText(getApplicationContext(),username, Toast.LENGTH_SHORT).show();

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(verify.this);
                        builder.setMessage("Operation failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        VerifyRequest loginRequest = new VerifyRequest(username, password, JSON_URL, responseListener);
        RequestQueue queue = Volley.newRequestQueue(verify.this);
        queue.add(loginRequest);
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.v_verify:
                JSON_URL = "http://life2.net16.net/verify.php";
                sendRequest();
                break;

            case R.id.v_delete:

                JSON_URL = "http://life2.net16.net/delete.php";
                sendRequest();
                break;
            case R.id.v_change:

                JSON_URL = "http://life2.net16.net/change.php";
                sendRequest();
                break;
        }
    }
}
