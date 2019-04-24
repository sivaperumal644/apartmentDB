package com.example.sivaperumal.apartmentdb.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sivaperumal.apartmentdb.R;

public class ServicesDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_detail);
        String details = getIntent().getExtras().getString("details");
        int image = getIntent().getExtras().getInt("image");
        String companyName = getIntent().getExtras().getString("company_name");
        String phoneNumber = getIntent().getExtras().getString("phone");
        String address = getIntent().getExtras().getString("address");
        ImageView back = findViewById(R.id.backButton);

        if(details.equals("Electricals Details")){
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ServicesDetailActivity.this, ElectricianDetailsActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if(details.equals("Plumbing Details")){
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ServicesDetailActivity.this, PlumberDetailsActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if(details.equals("Laundry Details")){
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ServicesDetailActivity.this, LaundryDetailsActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else{
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ServicesDetailActivity.this, HouseKeepingActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        TextView detailText = findViewById(R.id.serviceDetailTextView);
        TextView company = findViewById(R.id.companyNameTextView);
        ImageView imageView = findViewById(R.id.profilePic);
        TextView phone = findViewById(R.id.phoneNumber);
        TextView addressOfTheCompany = findViewById(R.id.officeAddressTextView);

        detailText.setText(details);
        company.setText(companyName);
        imageView.setImageResource(image);
        phone.setText(phoneNumber);
        addressOfTheCompany.setText(address);



    }
}
