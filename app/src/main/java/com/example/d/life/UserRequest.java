package com.example.d.life;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class UserRequest extends StringRequest {
    private static final String Register_Request_URL="http://life2.net16.net/user.php";
    private Map<String,String> params;


    public UserRequest(String username,Response.Listener<String> listener){

        super(Method.POST,Register_Request_URL,listener,null);
        params= new HashMap<>( );
        String string2 = " wants to donate to you";
        username  =username.replace(string2, "");
        params.put("username",username);
      }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

