package com.example.roshan.apartmentdemo.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.roshan.apartmentdemo.Database.QueryUtility;
import com.example.roshan.apartmentdemo.R;

public class OwnerDashboardActivity extends AppCompatActivity {

    QueryUtility myQuery;

    public void flats(View view) {
        Intent intent = new Intent(OwnerDashboardActivity.this,flatlist.class);
        startActivity(intent);

    }

    public void tenants(View view) {
        Intent intent = new Intent(OwnerDashboardActivity.this,tenantlist.class);
        startActivity(intent);
    }

    private class GetDatabaseTask extends AsyncTask<Void, Void, QueryUtility> {

        @Override
        protected QueryUtility doInBackground(Void... voids) {
            return QueryUtility.getInstance(getApplicationContext());
        }

        @Override
        protected void onPostExecute(QueryUtility queryUtility) {
            myQuery = queryUtility;
            myQuery.getTenantNames(null);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_dashboard);
        getSupportActionBar().setTitle("Dashboard");
        GetDatabaseTask getDatabaseTask = new GetDatabaseTask();
        getDatabaseTask.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            logOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void logOut() {
        QueryUtility.getInstance(getApplicationContext()).setSessionTable("null", "null");
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}




