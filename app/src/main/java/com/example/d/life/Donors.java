package com.example.d.life;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Donors extends AppCompatActivity implements View.OnClickListener {

    public static final String JSON_URL = "http://life2.net16.net/table2.php";

    private Button buttonGet;

    private ListView listView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donors);

        buttonGet = (Button) findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);
        spinner = (Spinner) findViewById(R.id.spinner);



    }

    private void sendRequest()  {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Donors.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                String state=spinner.getSelectedItem().toString();
                Map<String, String> params = new HashMap<>();
                params.put("state",state);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json) {
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        CustomList cl = new CustomList(this, ParseJSON.organs, ParseJSON.bloods, ParseJSON.contacts, ParseJSON.ages, ParseJSON.states,ParseJSON.reasons, ParseJSON.names, ParseJSON.usernames);
        listView.setAdapter(cl);
    }

    @Override
    public void onClick(View v) {
        sendRequest();
    }


}