package com.example.roshan.apartmentdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roshan.apartmentdemo.Helper.CustomAdapter;
import com.example.roshan.apartmentdemo.R;

import java.util.ArrayList;
import java.util.List;

public class tenantlist extends AppCompatActivity {
    ListView list;
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

    Integer[] imgid={
            R.drawable.person,
            R.drawable.pn,
            R.drawable.hai,
            R.drawable.man,
            R.drawable.model
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenantlist);CustomAdapter adapter=new CustomAdapter(this, tenantname, imgid,flatname);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String Slecteditem= tenantname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
}