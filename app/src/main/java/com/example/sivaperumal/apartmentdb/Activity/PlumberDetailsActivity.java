package com.example.sivaperumal.apartmentdb.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sivaperumal.apartmentdb.R;

public class PlumberDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber_details);
        getSupportActionBar().setTitle("Plumbing Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final LinearLayout mrAssociate = findViewById(R.id.MRplumbing);
        mrAssociate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(PlumberDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Plumbing Details");
                mrElectricals.putExtra("company_name", "MR Associate Plumbing");
                mrElectricals.putExtra("image", R.drawable.mr_electricals);
                mrElectricals.putExtra("phone", "+91 9152348191");
                mrElectricals.putExtra("address", "No. 61, V. K. K. Menon Road, New Siddhapudur, Sidhapudur, Coimbatore - 641044, Freevari Appartment");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout future = findViewById(R.id.futurePlumbing);
        future.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(PlumberDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Plumbing Details");
                mrElectricals.putExtra("company_name", "Future Plumbing");
                mrElectricals.putExtra("image", R.drawable.future_plumbing);
                mrElectricals.putExtra("phone", "+91 9152695975");
                mrElectricals.putExtra("address", "No.69/1, Thirunavukkarasu Street, Rathinapuri, Coimbatore - 641027, Near LALA Mahal");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout sugirthan = findViewById(R.id.sugirthanPlumbing);
        sugirthan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(PlumberDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Plumbing Details");
                mrElectricals.putExtra("company_name", "Sugirthan Plumbing");
                mrElectricals.putExtra("image", R.drawable.sugirthan_plumbing);
                mrElectricals.putExtra("phone", "+91 9865038715");
                mrElectricals.putExtra("address", "94, Vcv Layout Shanmuga Theatre Road, RS Puram Coimbatore, Coimbatore - 641002, Opp Shanmuga Theatre");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout blessing = findViewById(R.id.blessingPlumbing);
        blessing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(PlumberDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Plumbing Details");
                mrElectricals.putExtra("company_name", "Blessing Plumbing");
                mrElectricals.putExtra("image", R.drawable.blessing_plumbing);
                mrElectricals.putExtra("phone", "+91 9152871589");
                mrElectricals.putExtra("address", "No 124/53, Sithi Vinayagar Colony, Vadavalli, Coimbatore - 641041, Siruvani Road");
                startActivity(mrElectricals);
            }
        });

        final LinearLayout SVN = findViewById(R.id.svnPlumbing);
        SVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mrElectricals = new Intent(PlumberDetailsActivity.this, ServicesDetailActivity.class);
                mrElectricals.putExtra("details", "Plumbing Details");
                mrElectricals.putExtra("company_name", "SVN Plumbing");
                mrElectricals.putExtra("image", R.drawable.svn_plumbing);
                mrElectricals.putExtra("phone", "+91 8940444402");
                mrElectricals.putExtra("address", "No 50E, Mullai Nagar Vk Road Hudo Colony, Peelamedu, Coimbatore - 641004, Near Railway Gate Opposite");
                startActivity(mrElectricals);
            }
        });

    }
}
