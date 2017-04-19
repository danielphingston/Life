package com.example.d.life;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by danie on 16-04-2017.
 */
public class CustomList2 extends ArrayAdapter<String> {

    private String[] usernames1;
    private Activity context;


    public CustomList2(Activity context, String[] usernames1) {
        super(context, R.layout.list_names, usernames1);
        this.context = context;
        this.usernames1 = usernames1;


    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_names, null, true);

        TextView textViewusername = (TextView) listViewItem.findViewById(R.id.usernames1);




        textViewusername.setText(usernames1[position]);

        return listViewItem;

    }

}



