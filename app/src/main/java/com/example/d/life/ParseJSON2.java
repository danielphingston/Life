package com.example.d.life;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON2 {

    public static String[] usernames1;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_USERNAME="username";


    private JSONArray users = null;

    private String json;

    public ParseJSON2(String json){
        this.json = json;
    }

    protected void parseJSON2(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);


            usernames1= new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);

                usernames1[i]=jo.getString(KEY_USERNAME);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}