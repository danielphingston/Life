package com.example.d.life;

import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String Register_Request_URL="http://life2.net16.net/Register.php";
    private Map<String,String> params;


    public RegisterRequest(String name,String email, String username,String password,String location,String contact,Response.Listener<String> listener){

        super(Method.POST,Register_Request_URL,listener,null);
        params= new HashMap<>( );
        params.put( "name",name );
        params.put( "email",email );
        params.put("username",username);
        params.put("password",password);
        params.put("location",location);
        params.put("contact",contact);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
