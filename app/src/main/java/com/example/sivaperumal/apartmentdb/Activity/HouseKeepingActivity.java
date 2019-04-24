package com.example.sivaperumal.apartmentdb.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sivaperumal.apartmentdb.R;

public class HouseKeepingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_keeping);
        getSupportActionBar().setTitle("HouseKeeping Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final LinearLayout pioneer = findViewById(R.id.pioneerServices);
        pioneer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(HouseKeepingActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "HouseKeeping Details");
                mrElectricals.putExtra("company_name", "Pioneer Cleaning Services");
                mrElectricals.putExtra("image", R.drawable.pioneer_services);
                mrElectricals.putExtra("phone", "+91 9152342610");
                mrElectricals.putExtra("address", "8th Street, Cross Cut Road, Gandhipuram, Coimbatore - 641012");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout ethicare = findViewById(R.id.ethicareServices);
        ethicare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(HouseKeepingActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "HouseKeeping Details");
                mrElectricals.putExtra("company_name", "Ethicare Facility Services");
                mrElectricals.putExtra("image", R.drawable.ethicare_services);
                mrElectricals.putExtra("phone", "+91 9152417969");
                mrElectricals.putExtra("address", "VNC Buildings, 870, Trichy Road, Ramanathapuram, Coimbatore - 641045, Near : Hotel Surya");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout hr = findViewById(R.id.hrServices);
        hr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(HouseKeepingActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Housekeeping Details");
                mrElectricals.putExtra("company_name", "HR Cleaning Services");
                mrElectricals.putExtra("image", R.drawable.hr_services);
                mrElectricals.putExtra("phone", "+91 9152348381");
                mrElectricals.putExtra("address", "No 7, Shanmuga Nagar, Sungam Byepass, Ramanathapuram Coimbatore, Coimbatore - 641045, Near KTM Showroom");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout nathiya = findViewById(R.id.nathiyaServices);
        nathiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(HouseKeepingActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "HouseKeeping Details");
                mrElectricals.putExtra("company_name", "Nathiya Home Care Services");
                mrElectricals.putExtra("image", R.drawable.nathiya_services);
                mrElectricals.putExtra("phone", "+91 9152339054");
                mrElectricals.putExtra("address", "1/8, Murugan Street, Ganapathy, Coimbatore - 641006, GEM Colony");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout steam = findViewById(R.id.steamServices);
        steam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(HouseKeepingActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "HouseKeeping Details");
                mrElectricals.putExtra("company_name", "Steam Clean");
                mrElectricals.putExtra("image", R.drawable.steam_services);
                mrElectricals.putExtra("phone", "+91 9152454716");
                mrElectricals.putExtra("address", "NCR Complex, 1st Floor, Maruthamalai Main Road, Pappanaickenpudur, Coimbatore - 641041, Opposite Andhra Bank");
                startActivity(mrElectricals);
            }
        });

    }
}
