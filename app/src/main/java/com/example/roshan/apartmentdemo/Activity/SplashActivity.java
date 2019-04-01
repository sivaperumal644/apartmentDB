package com.example.roshan.apartmentdemo.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.roshan.apartmentdemo.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView title = findViewById(R.id.titleTextView);
        String text = "<font color=>Apartment</font><font color=#C96FA2> DB</font>";
        title.setText(Html.fromHtml(text));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(main);
                finish();
            }
        },2000);
    }
}
