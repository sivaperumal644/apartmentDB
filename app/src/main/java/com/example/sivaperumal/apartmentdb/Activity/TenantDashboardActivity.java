package com.example.sivaperumal.apartmentdb.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sivaperumal.apartmentdb.Database.QueryUtility;
import com.example.sivaperumal.apartmentdb.R;

public class TenantDashboardActivity extends AppCompatActivity {

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_dashboard);
        getSupportActionBar().setTitle("Dashboard");


        userID =getSharedPreferences("session", Context.MODE_PRIVATE).getString("tenantID", "null");

        LinearLayout profile = findViewById(R.id.viewProfile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(TenantDashboardActivity.this, TenantView.class);
                QueryUtility queryUtility = QueryUtility.getInstance(getApplicationContext());
                profileIntent.putExtra("tenantID", userID.trim());
                profileIntent.putExtra("isOwner", false);
                startActivity(profileIntent);
            }
        });

        LinearLayout complaints = findViewById(R.id.logComplaints);
        complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "sivaperumal644@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Complaints");
                startActivity(intent);
            }
        });

        LinearLayout services = findViewById(R.id.accessServices);
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent service = new Intent(TenantDashboardActivity.this, ServicesActivity.class);
                startActivity(service);
            }
        });
    }
}
