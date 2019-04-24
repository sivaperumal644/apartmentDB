package com.example.sivaperumal.apartmentdb.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sivaperumal.apartmentdb.R;

public class LaundryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry_details);
        getSupportActionBar().setTitle("Laundry Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final LinearLayout band = findViewById(R.id.bandBoxLaundry);
        band.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(LaundryDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Laundry Details");
                mrElectricals.putExtra("company_name", "Band Boxe Dry Cleaners");
                mrElectricals.putExtra("image", R.drawable.bandboxe_laundry);
                mrElectricals.putExtra("phone", "+91 9152340074");
                mrElectricals.putExtra("address", "No 826, Cross Cut Road, Gandhipuram, Coimbatore - 641012, Near to Tanishq Jewellery");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout amman = findViewById(R.id.ammanLaundry);
        amman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(LaundryDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Laundry Details");
                mrElectricals.putExtra("company_name", "Sri Amman Dry Cleaners");
                mrElectricals.putExtra("image", R.drawable.amman_laundry);
                mrElectricals.putExtra("phone", "+91 9152303442");
                mrElectricals.putExtra("address", "No 55/68, Kamarajar Road, Singanallur, Uppilipalayam, Coimbatore - 641015, Opposite to Singanallur New Bus Stand and Near By Mosque ");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout sai = findViewById(R.id.saiDryLaundry);
        sai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(LaundryDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Laundry Details");
                mrElectricals.putExtra("company_name", "Sai Dry Cleaners");
                mrElectricals.putExtra("image", R.drawable.sai_laundry);
                mrElectricals.putExtra("phone", "+91 9152525705");
                mrElectricals.putExtra("address", "No 88, Kamarajar Road. Singanallur Bus Stand Opp Main Road, Singanallur, Coimbatore - 641005, Sri Madurai Meenakshi Hotel Beside Shop");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout washouse = findViewById(R.id.washHouseLaundry);
        washouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(LaundryDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Laundry Details");
                mrElectricals.putExtra("company_name", "Washouse Services");
                mrElectricals.putExtra("image", R.drawable.washouse_laundry);
                mrElectricals.putExtra("phone", "+91 422 4202322");
                mrElectricals.putExtra("address", "565 A, Avinashi Road, Papanaickenpalayam, Coimbatore - 641037, Next to Manchester Towers");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout hub = findViewById(R.id.hubLaundry);
        hub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(LaundryDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Laundry Details");
                mrElectricals.putExtra("company_name", "Laundry Hub");
                mrElectricals.putExtra("image", R.drawable.hub_laundry);
                mrElectricals.putExtra("phone", "+91 422 4218180");
                mrElectricals.putExtra("address", "No 78, West Sambandham Street, RS Puram, Coimbatore - 641002, Near Fitness One");
                startActivity(mrElectricals);
            }
        });

    }
}
