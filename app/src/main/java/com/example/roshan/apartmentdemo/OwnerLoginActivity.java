package com.example.roshan.apartmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class OwnerLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);
    }

    public void performSignIn(View view) {
        Toast.makeText(this, "This action calls the sign-in method.", Toast.LENGTH_SHORT).show();
    }

    public void handleTroubleSigningIn(View view) {
        Toast.makeText(this, "This action calls the trouble signing in method.", Toast.LENGTH_SHORT).show();
    }
}
