package com.example.roshan.apartmentdemo.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.roshan.apartmentdemo.R;

public class EditTenantDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tenant_details);
        getSupportActionBar().setTitle("Edit Tenant Details");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.saveButton) {
            // This should handle SAVE action
            /* TODO: For Roshan: This will perform save */
        }
        return super.onOptionsItemSelected(item);
    }

}

