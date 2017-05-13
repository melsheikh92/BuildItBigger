package com.example.mahmoud.telljokesandroidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TellJokeActivity extends AppCompatActivity {


    TextView tvjoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_joke);
        tvjoke = (TextView) findViewById(R.id.tv_joke);


        Intent intent = getIntent();
        if (intent.hasExtra("joke")) {

            tvjoke.setText(intent.getStringExtra("joke"));

        }

    }
}
