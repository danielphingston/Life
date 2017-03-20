package com.example.d.life;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {
    public static String[] ids;
    public static String[] names;
    public static String[] emails;
    public static String[] ages;
    public static String[] states;
    public static String[] citys;
    public static String[] reasons;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_AGE ="age";
    public static final String KEY_STATE ="state";
    public static final String KEY_CITY ="city";
    public static final String KEY_REASON ="reason";


    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            names = new String[users.length()];
            emails = new String[users.length()];
            ages = new String[users.length()];
            states =new String[users.length()];
            citys =new String[users.length()];
            reasons =new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);
                emails[i] = jo.getString(KEY_EMAIL);
                ages[i] = jo.getString( KEY_AGE );
                states[i]=jo.getString( KEY_STATE );
                citys[i]=jo.getString( KEY_CITY );
                reasons[i]=jo.getString( KEY_REASON );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}