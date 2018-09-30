package com.example.roshan.apartmentdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TenantLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_login);
        getSupportActionBar().setTitle("Apartment Demo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void performSignIn(View view) {
        Toast.makeText(this, "This action calls the sign-in method.", Toast.LENGTH_SHORT).show();
    }

    public void handleTroubleSigningIn(View view) {
        new AlertDialog.Builder(this).setMessage("Please contact the flat owner who has registered your tenant account for your login credentials.\n\nYou can request new ID from the owner if you want.")
                .setTitle("Trouble signing in")
                .setPositiveButton(
                        "Request new ID",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(TenantLoginActivity.this, "Request sent to your flat owner", Toast.LENGTH_SHORT).show();
                            }
                        }
                )
                .setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }
                ).setCancelable(false).create().show();

    }
}

/* TODO: Need to implement back button in the action bar for this activity dude, so that it will go back to Main Activity. */