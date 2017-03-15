package com.example.d.life;

import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String Register_Request_URL="http://life2.net16.net/Register.php";
    private Map<String,String> params;


    public RegisterRequest(String username,String password,Response.Listener<String> listener){

        super(Method.POST,Register_Request_URL,listener,null);
        params= new HashMap<>( );
        params.put("username",username);
        params.put("password",password);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
