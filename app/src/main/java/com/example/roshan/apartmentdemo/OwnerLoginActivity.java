package com.example.roshan.apartmentdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
        new AlertDialog.Builder(this).setMessage("If you have forgotten your password, you can generate a new one using an OTP.\n\nIf you have forgotten your user ID, please contact the administrator.")
                .setTitle("Trouble signing in")
                .setPositiveButton(
                        "Forgot Password",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(OwnerLoginActivity.this, "Assume that OTP is sent to your registered mobile number", Toast.LENGTH_LONG).show();
                            }
                        }
                )
                .setNegativeButton(
                        "Forgot ID",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(OwnerLoginActivity.this, "Please contact your administrator for help.", Toast.LENGTH_LONG).show();
                            }
                        }
                )
                .setNeutralButton(
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