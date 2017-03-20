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
    private String[] ids;
    private String[] names;
    private String[] emails;
    private String[] ages;
    private String[] states;
    private String[] citys;
    private String[] reasons;
    private Activity context;


    public CustomList(Activity context, String[] ids, String[] names, String[] emails,String[] ages,String[] states,String[] citys,String[] reasons) {
        super(context, R.layout.list_view_layout, ids);
        this.context = context;
        this.ids = ids;
        this.names = names;
        this.emails = emails;
        this.ages = ages;
        this.states=states;
        this.citys=citys;
        this.reasons=reasons;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.organs);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.bloods);
        TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.contacts);
        TextView textViewAge = (TextView) listViewItem.findViewById(R.id.ages);
        TextView textViewState = (TextView) listViewItem.findViewById(R.id.states);
        TextView textViewCity =(TextView)  listViewItem.findViewById( R.id.citys );
        TextView textViewReason=(TextView) listViewItem.findViewById( R.id.reasons );




        textViewId.setText(ids[position]);
        textViewName.setText(names[position]);
        textViewEmail.setText(emails[position]);
        textViewAge.setText( ages[position] );
        textViewState.setText( states[position] );
        textViewCity.setText( citys[position] );
        textViewReason.setText( reasons[position] );

        return listViewItem;
    }
}