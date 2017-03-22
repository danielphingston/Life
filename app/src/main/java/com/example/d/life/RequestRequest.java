package com.example.d.life;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class RequestRequest extends StringRequest {
    private static final String Register_Request_URL="http://life2.net16.net/Request.php";
    private Map<String,String> params;


    public RequestRequest(String organ, String blood, String contact,int age,String state,String city, String reason,String username ,Response.Listener<String> listener){

        super(Method.POST,Register_Request_URL,listener,null);
        params= new HashMap<>( );
        params.put("organ",organ);
        params.put("blood",blood);
        params.put("contact",contact+"");
        params.put("age",age + "");
        params.put("city",city);
        params.put("state",state );
        params.put("reason",reason);
        params.put( "username",username );


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}


