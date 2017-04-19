package com.example.d.life;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class VerifyRequest extends StringRequest {

    private Map<String,String> params;


    public VerifyRequest(String username,String password,String JSON_URL,Response.Listener<String> listener){

        super(Method.POST,JSON_URL,listener,null);
        params= new HashMap<>( );
        params.put("username",username);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
