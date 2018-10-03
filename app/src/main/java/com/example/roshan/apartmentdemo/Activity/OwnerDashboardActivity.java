package com.example.roshan.apartmentdemo.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roshan.apartmentdemo.Database.QueryUtility;
import com.example.roshan.apartmentdemo.Helper.CustomAdapter;
import com.example.roshan.apartmentdemo.R;

public class OwnerDashboardActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "A Block",
            "B Block ",
            "C Block ",
            "D Block ",
            "E Block "
    };
    String[] flatcity ={
            "coimbatore",
            "Madurai",
            "Chennai",
            "Bangalore",
            "Kerala"
    };

    Integer[] imgid={
            R.drawable.person,
            R.drawable.pn,
            R.drawable.hai,
            R.drawable.man,
            R.drawable.model
    };
    String[] tenantname ={
            "Sivaram",
            "Vineesh",
            "Sivaperumal",
            "Roshan",
            "Saravanan"
    };
    String[] flatname ={
            "A Block",
            "B Block ",
            "C Block ",
            "D Block ",
            "E Block "
    };




    /* TODO: Create a menu in the action bar for "SAVE" - which will save the data entered */

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
        CustomAdapter adapter=new CustomAdapter(this, itemname, imgid,flatcity);
        list = findViewById(R.id.flatList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
        CustomAdapter adapter1=new CustomAdapter(this, tenantname, imgid,flatname);
        list = findViewById(R.id.tenantList);
        list.setAdapter(adapter1);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String Slecteditem= tenantname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
        GetDatabaseTask getDatabaseTask = new GetDatabaseTask();
        getDatabaseTask.execute();
        FloatingActionButton fab = findViewById(R.id.fab);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            fab.setTooltipText("Add new entry");
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new AlertDialog.Builder(getApplicationContext()).setTitle("Add new entry").setMessage("Please choose if you wish to add a new flat or a tenant").setPositiveButton("ADD NEW FLAT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Intent to Add Flat Activity
                    }
                }).setNeutralButton("Add new Tenant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), TenantEditActivity.class));
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setCancelable(true).create().show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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


