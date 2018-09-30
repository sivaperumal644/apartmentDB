package com.example.roshan.apartmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class OwnerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_dashboard);
        getSupportActionBar().setTitle("Dashboard");
    }

    public void logOut() {
        Toast.makeText(this, "Assume this performs log-out", Toast.LENGTH_SHORT).show();
    }
}


/*TODO: Implement a three-dot menu with item "Log Out" in action bar to call logOut method */
/* TODO: The BACK functionality should be REMOVED for this activity. If user performs back, it should exit to launcher, it should not show login activity */