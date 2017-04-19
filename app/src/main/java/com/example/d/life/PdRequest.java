package com.example.d.life;

import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PdRequest extends StringRequest {
    private static final String Register_Request_URL="http://life2.net16.net/pd.php";
    private Map<String,String> params;


    public PdRequest(String username,String organ,String blood1,String blood2,Response.Listener<String> listener){

        super(Method.POST,Register_Request_URL,listener,null);
        params= new HashMap<>( );
        params.put("username",username);
        params.put("organ",organ );
        params.put("blood1",blood1 );
        params.put("blood2",blood2);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
