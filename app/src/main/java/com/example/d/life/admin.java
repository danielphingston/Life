package com.example.d.life;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void verify(View v) {
        Button button = (Button) v;
        Intent intent = new Intent(this, verify.class);
        intent.putExtra("verify","verify");
        startActivity(intent);
    }

    public void delete(View v) {
        Button l = (Button) v;
        Intent intent = new Intent(this, verify.class);
        intent.putExtra("verify","delete");
        startActivity(intent);

    }

    public void change(View v) {
        Intent intent = new Intent(admin.this, verify.class);
        intent.putExtra("verify","change");
        startActivity(intent);
    }
}
