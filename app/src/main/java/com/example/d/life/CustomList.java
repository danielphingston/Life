package com.example.d.life;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
    private Activity context;


    public CustomList(Activity context, String[] organs, String[] bloods, String[] contacts,String[] ages,String[] states,String[] citys,String[] reasons,String[] names) {
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

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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




        textViewOrgan.setText(organs[position]);
        textViewBlood.setText(bloods[position]);
        textViewContact.setText(contacts[position]);
        textViewAge.setText( ages[position] );
        textViewState.setText( states[position] );
        textViewCity.setText( citys[position] );
        textViewReason.setText( reasons[position] );
        textViewName.setText(names[position]);

        return listViewItem;
    }
}