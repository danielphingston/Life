package com.example.d.life;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;




public class FAQ extends AppCompatActivity {

    TextView txt_help_gest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_faq );

        for(int j=0; j<4; j++) {
            String x = "a" + j;
            int resID = getResources().getIdentifier( x, "id", getPackageName() );
            txt_help_gest = (TextView) findViewById(resID);
            // hide until its title is clicked
            txt_help_gest.setVisibility( View.GONE );
        }
    }



    public void toggle_contents(View v){
        //set the string to be passed in contentdescription in xml
        String x=v.getContentDescription().toString();
        int resID = getResources().getIdentifier( x, "id", getPackageName() );
        txt_help_gest = (TextView) findViewById(resID);
        txt_help_gest.setVisibility( txt_help_gest.isShown()
                ? View.GONE
                : View.VISIBLE );

}




}
