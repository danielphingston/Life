package com.example.d.life;

import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class send extends StringRequest {
    private static final String Register_Request_URL="http://life2.net16.net/notify.php";
    private Map<String,String> params;


    public send(String notify,String username,Response.Listener<String> listener){

        super(Method.POST,Register_Request_URL,listener,null);
        params= new HashMap<>( );
        params.put( "notify",notify);
        params.put("username",username);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
