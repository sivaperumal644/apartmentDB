package com.example.roshan.apartmentdemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.roshan.apartmentdemo.R;

public class ElectricianDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician_details);
        getSupportActionBar().setTitle("Electrical Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final LinearLayout mrAssociate = findViewById(R.id.MRelectricals);
        mrAssociate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(ElectricianDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Electricals Details");
                mrElectricals.putExtra("company_name", "MR Associate Electricals");
                mrElectricals.putExtra("image", R.drawable.mr_electricals);
                mrElectricals.putExtra("phone", "+91 9152348191");
                mrElectricals.putExtra("address", "No. 61, V. K. K. Menon Road, New Siddhapudur, Sidhapudur, Coimbatore - 641044, Freevari Appartment");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout master = findViewById(R.id.masterElectricals);
        master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(ElectricianDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Electricals Details");
                mrElectricals.putExtra("company_name", "Master Electricals");
                mrElectricals.putExtra("image", R.drawable.master_electricals);
                mrElectricals.putExtra("phone", "+91 9487892178");
                mrElectricals.putExtra("address", "No.20/110, Kamachiamman Kovil Street, Ramanathapuram, Coimbatore - 641045, Behind Sungam Chinthamani");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout vetri = findViewById(R.id.vetriVinayagaElectricals);
        vetri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(ElectricianDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Electricals Details");
                mrElectricals.putExtra("company_name", "Vetri Vinayaga Electricals");
                mrElectricals.putExtra("image", R.drawable.vetri_electricals);
                mrElectricals.putExtra("phone", "+91 9152281245");
                mrElectricals.putExtra("address", "35 A, MGR STREET, Vadavalli, Coimbatore - 641041, Near Ragavendra School");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout npr = findViewById(R.id.nprElectrical);
        npr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(ElectricianDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Electricals Details");
                mrElectricals.putExtra("company_name", "NPR Electricals");
                mrElectricals.putExtra("image", R.drawable.place_holder);
                mrElectricals.putExtra("phone", "+91 9152324349");
                mrElectricals.putExtra("address", "No 50, 3rd Street, Sindhu Nagar, Ganapathy, Coimbatore - 641006");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout vs = findViewById(R.id.vsElectrical);
        vs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(ElectricianDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Electricals Details");
                mrElectricals.putExtra("company_name", "VS Electricals");
                mrElectricals.putExtra("image", R.drawable.vs_electricals);
                mrElectricals.putExtra("phone", "+91 9152847395");
                mrElectricals.putExtra("address", "No 23, Venkatachalapathy Nagar, Cheran Ma Nagar, Coimbatore - 641035, Near VKR Kalyana Mandapam");
                startActivity(mrElectricals);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ElectricianDetailsActivity.this, ServicesActivity.class);
        startActivity(back);
        super.onBackPressed();
    }
}
