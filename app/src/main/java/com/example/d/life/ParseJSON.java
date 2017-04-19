package com.example.d.life;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {
    public static String[] organs;
    public static String[] bloods;
    public static String[] contacts;
    public static String[] ages;
    public static String[] states;
    public static String[] reasons;
    public static String[] names;
    public static String[] usernames;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ORGAN = "organ";
    public static final String KEY_BLOOD = "blood";
    public static final String KEY_CONTACT = "contact";
    public static final String KEY_AGE ="age";
    public static final String KEY_STATE ="state";
    public static final String KEY_REASON ="reason";
    public static final String KEY_NAME="name";
    public static final String KEY_USERNAME="username";


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

            organs = new String[users.length()];
            bloods = new String[users.length()];
            contacts = new String[users.length()];
            ages = new String[users.length()];
            states =new String[users.length()];
            reasons =new String[users.length()];
            names= new String[users.length()];
            usernames= new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                organs[i] = jo.getString(KEY_ORGAN);
                bloods[i] = jo.getString(KEY_BLOOD);
                contacts[i] = jo.getString(KEY_CONTACT);
                ages[i] = jo.getString( KEY_AGE );
                states[i]=jo.getString( KEY_STATE );
                reasons[i]=jo.getString( KEY_REASON );
                names[i]=jo.getString(KEY_NAME);
                usernames[i]=jo.getString(KEY_USERNAME);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}