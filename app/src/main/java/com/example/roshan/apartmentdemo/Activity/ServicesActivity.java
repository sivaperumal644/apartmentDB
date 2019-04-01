package com.example.roshan.apartmentdemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.roshan.apartmentdemo.R;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Button electrical = findViewById(R.id.electricianButton);
        electrical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent electrical = new Intent(ServicesActivity.this, ElectricianDetailsActivity.class);
                startActivity(electrical);
            }
        });

        Button plumber = findViewById(R.id.plumberButton);
        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plumbing = new Intent(ServicesActivity.this, PlumberDetailsActivity.class);
                startActivity(plumbing);
            }
        });

        Button laundry = findViewById(R.id.laundryButton);
        laundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent laundry = new Intent(ServicesActivity.this, LaundryDetailsActivity.class);
                startActivity(laundry);
            }
        });

        Button house = findViewById(R.id.houseKeepingButton);
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent houseKeeping = new Intent(ServicesActivity.this, HouseKeepingActivity.class);
                startActivity(houseKeeping);
            }
        });

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ServicesActivity.this, TenantDashboardActivity.class);
                startActivity(back);
                finish();
            }
        });
    }
}
