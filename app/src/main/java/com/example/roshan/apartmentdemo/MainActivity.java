package com.example.roshan.apartmentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTenantLoginActivity(View view) {
        startActivity(new Intent(this, TenantLoginActivity.class));
    }

    public void startOwnerLoginActivity(View view) {
        startActivity(new Intent(this, OwnerLoginActivity.class));
    }
}
