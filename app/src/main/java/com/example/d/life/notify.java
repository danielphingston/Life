package com.example.d.life;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class notify extends AppCompatActivity implements View.OnClickListener {

    // public static final String JSON_URL = "http://life2.net16.net/array.php";
    public String JSON_URL;
    String password;
    String location;
    String contact;
    String name;
    String email;
    private Button array;
    private Button vnb;
    private Button x;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        array = (Button) findViewById(R.id.array);
        array.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.list);

        vnb = (Button) findViewById(R.id.VNB);
        vnb.setOnClickListener(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                TextView textview = (TextView) view.findViewById(R.id.usernames1);
                final String username = textview.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {


                        try {

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");


                            if (success) {


                                password = jsonResponse.getString("password");
                                location = jsonResponse.getString("location");
                                contact = jsonResponse.getString("contact");
                                name = jsonResponse.getString("name");
                                email = jsonResponse.getString("email");


                            } else {
                                /*AlertDialog.Builder builder = new AlertDialog.Builder(notify.this);
                                builder.setMessage("Login failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                                */
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(notify.this, userprofile.class);
                        intent.putExtra("username", username);
                        intent.putExtra("location", location);
                        intent.putExtra("email", email);
                        intent.putExtra("contact", contact);
                        intent.putExtra("name", name);

                        startActivity(intent);


                    }
                };


                UserRequest loginRequest = new UserRequest(username, responseListener);
                RequestQueue queue = Volley.newRequestQueue(notify.this);
                queue.add(loginRequest);


            }
        });


    }

    private void sendRequest() {
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(notify.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String username = loginData.getString("username", null);

                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void showJSON(String json) {
        ParseJSON2 pj = new ParseJSON2(json);
        pj.parseJSON2();
        CustomList2 cl = new CustomList2(this, ParseJSON2.usernames1);
        listView.setAdapter(cl);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.array:
                JSON_URL = "http://life2.net16.net/array.php";
                sendRequest();
                break;
            case R.id.VNB:
                JSON_URL = "http://life2.net16.net/vn.php";
                sendRequest();
                break;
        }
    }


}