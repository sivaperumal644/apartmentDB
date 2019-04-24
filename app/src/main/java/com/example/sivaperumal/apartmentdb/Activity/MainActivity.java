package com.example.sivaperumal.apartmentdb.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sivaperumal.apartmentdb.Database.QueryUtility;
import com.example.sivaperumal.apartmentdb.R;

public class MainActivity extends AppCompatActivity {

    private class GetDatabaseTask extends AsyncTask<Void, Void, QueryUtility> {

        @Override
        protected QueryUtility doInBackground(Void... voids) {
            return QueryUtility.getInstance(getApplicationContext());
        }

        @Override
        protected void onPostExecute(QueryUtility queryUtility) {
            myQuery = queryUtility;
            //Toast.makeText(MainActivity.this, "Successfully connected to DB", Toast.LENGTH_SHORT).show();
            //Toast.makeText(MainActivity.this, queryUtility.getSession(), Toast.LENGTH_SHORT).show();
            autoSignIn();
        }
    }

    QueryUtility myQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetDatabaseTask getDatabaseTask = new GetDatabaseTask();
        getDatabaseTask.execute();
        getSupportActionBar().hide();
    }

    public void startTenantLoginActivity(View view) {
        startActivity(new Intent(this, TenantLoginActivity.class));

    }

    public void startOwnerLoginActivity(View view) {
        startActivity(new Intent(this, OwnerLoginActivity.class));
    
    }

    public void autoSignIn() {

        if(getSharedPreferences("session", Context.MODE_PRIVATE).getString("account", "").equals("Tenant")){
            Intent tdIntent = new Intent(this, TenantDashboardActivity.class);
            tdIntent.putExtra("tenantID", getSharedPreferences("session", Context.MODE_PRIVATE).getString("tenantID", "null"));
            startActivity(new Intent(this, TenantDashboardActivity.class));
            finish();
        }
        if(myQuery.getSession().equals("owner")) {
            startActivity(new Intent(this, OwnerDashboardActivity.class));
            finish();
        }

    }




}
