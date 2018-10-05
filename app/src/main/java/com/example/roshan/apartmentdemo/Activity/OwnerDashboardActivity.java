//TODO: Can we turn this into a tabbed one, instead of the current arrangement?

package com.example.roshan.apartmentdemo.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roshan.apartmentdemo.Database.QueryUtility;
import com.example.roshan.apartmentdemo.Helper.CustomAdapter;
import com.example.roshan.apartmentdemo.R;

import java.security.acl.Owner;

public class OwnerDashboardActivity extends AppCompatActivity {
    ListView list, flatListView;
    TenantCursorAdapter tenantCursorAdapter;
    FlatCursorAdapter flatCursorAdapter;
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





    QueryUtility myQuery;

    public void flats(View view) {
        Intent intent = new Intent(OwnerDashboardActivity.this,flatlist.class);
        startActivity(intent);

    }

    public void tenants(View view) {
        Intent intent = new Intent(OwnerDashboardActivity.this,tenantlist.class);
        startActivity(intent);
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
                /* TODO: Must create item select functionality for both lists tenant and flat, so that when user selects an item, something happens.
                For now just implement a toast.
                 */

            }
        });
//        CustomAdapter adapter1=new CustomAdapter(this, tenantname, imgid,flatname);
//        list = findViewById(R.id.tenantList);
//        list.setAdapter(adapter1);
//
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                String Slecteditem= tenantname[+position];
//                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
//
//            }
//        });
        GetDatabaseTask getDatabaseTask = new GetDatabaseTask();
        getDatabaseTask.execute();

        FloatingActionButton fab = findViewById(R.id.fab);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            fab.setTooltipText("Add new entry");
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new AlertDialog.Builder(OwnerDashboardActivity.this).setTitle("Add new entry").setMessage("Please select if you wish to add new flat or tenant.")
                        .setPositiveButton("Add new Tenant", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(OwnerDashboardActivity.this, EditTenantDetails.class));
                                finish();
                            }
                        })
                        .setNegativeButton("Add new Flat", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(OwnerDashboardActivity.this, EditFlatDetails.class));
                                finish();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).create().show();

            }
        });
    }

    private class GetDatabaseTask extends AsyncTask<Void, Void, QueryUtility> {

        @Override
        protected QueryUtility doInBackground(Void... voids) {
            return QueryUtility.getInstance(getApplicationContext());
        }

        @Override
        protected void onPostExecute(QueryUtility queryUtility) {
            myQuery = queryUtility;
            Cursor tenantDataCursor = myQuery.getTenantData(null);
            Cursor flatDataCursor = myQuery.getFlatData(null);
            list = findViewById(R.id.tenantList);
            tenantCursorAdapter = new TenantCursorAdapter(OwnerDashboardActivity.this, tenantDataCursor);
            list.setAdapter(tenantCursorAdapter);
            flatListView = findViewById(R.id.flatList);
            flatCursorAdapter = new FlatCursorAdapter(OwnerDashboardActivity.this, flatDataCursor);
            flatListView.setAdapter(flatCursorAdapter);

        }
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

    public class TenantCursorAdapter extends CursorAdapter {

        public TenantCursorAdapter(Context context, Cursor c) {
            super(context, c, 0);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.custom, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView tenantName = view.findViewById(R.id.name);
            TextView tenantFlat = view.findViewById(R.id.city);
            ImageView avatar = view.findViewById(R.id.image);
            String tenantNameString = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String tenantFlatString = cursor.getString(cursor.getColumnIndexOrThrow("flat"));
            byte[] byteArray = cursor.getBlob(cursor.getColumnIndexOrThrow("image"));
            Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            tenantName.setText(tenantNameString);
            tenantFlat.setText(tenantFlatString);
            avatar.setImageBitmap(bm);
        }
    }

    public class FlatCursorAdapter extends CursorAdapter {

        public FlatCursorAdapter(Context context, Cursor c) {
            super(context, c, 0);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.custom, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView flatName = view.findViewById(R.id.name);
            TextView flatCity = view.findViewById(R.id.city);
            ImageView avatar = view.findViewById(R.id.image);
            String flatNameString = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String flatCityString = cursor.getString(cursor.getColumnIndexOrThrow("city"));
            byte[] byteArray = cursor.getBlob(cursor.getColumnIndexOrThrow("image"));
            Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            flatName.setText(flatNameString);
            flatCity.setText(flatCityString);
            avatar.setImageBitmap(bm);
        }
    }

}


