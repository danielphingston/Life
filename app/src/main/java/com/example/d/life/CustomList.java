package com.example.d.life;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Belal on 9/22/2015.
 */


public class CustomList extends ArrayAdapter<String> {
    private String[] organs;
    private String[] bloods;
    private String[] contacts;
    private String[] ages;
    private String[] states;
    private String[] citys;
    private String[] reasons;
    private String[] names;
    private String[] usernames;
    private Activity context;


    public CustomList(Activity context, String[] organs, String[] bloods, String[] contacts,String[] ages,String[] states,String[] citys,String[] reasons,String[] names,String[] usernames) {
        super(context, R.layout.list_view_layout, organs);
        this.context = context;
        this.organs = organs;
        this.bloods = bloods;
        this.contacts = contacts;
        this.ages = ages;
        this.states=states;
        this.citys=citys;
        this.reasons=reasons;
        this.names=names;
        this.usernames=usernames;



    }


    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewOrgan = (TextView) listViewItem.findViewById(R.id.organs);
        TextView textViewBlood = (TextView) listViewItem.findViewById(R.id.bloods);
        TextView textViewContact = (TextView) listViewItem.findViewById(R.id.contacts);
        TextView textViewAge = (TextView) listViewItem.findViewById(R.id.ages);
        TextView textViewState = (TextView) listViewItem.findViewById(R.id.states);
        TextView textViewCity =(TextView)  listViewItem.findViewById( R.id.citys );
        TextView textViewReason=(TextView) listViewItem.findViewById( R.id.reasons );
        TextView textViewName=(TextView) listViewItem.findViewById(R.id.names);
        TextView textViewusername=(TextView) listViewItem.findViewById(R.id.usernames);

        Button deleteImageView = (Button) listViewItem.findViewById(R.id.sbutton);
        deleteImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences loginData = getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String name = loginData.getString("username",null);

                String username =usernames[position].toString();
                String notify=name+" wants to donate to you";
                Toast.makeText(getContext(),notify,Toast.LENGTH_SHORT).show();


                   Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {

                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                Toast.makeText(getContext(), "Register Successful", Toast.LENGTH_SHORT).show();


                                if (success) {

                                    Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();


                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                    builder.setMessage("Register failed")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    };


                    send registerRequest = new send(notify,username,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getContext());
                    queue.add(registerRequest);

                }
            }



        );



        textViewOrgan.setText(organs[position]);
        textViewBlood.setText(bloods[position]);
        textViewContact.setText(contacts[position]);
        textViewAge.setText( ages[position] );
        textViewState.setText( states[position] );
        textViewCity.setText( citys[position] );
        textViewReason.setText( reasons[position] );
        textViewName.setText(names[position]);
        textViewusername.setText(usernames[position]);

        return listViewItem;

    }



}