package com.example.roshan.apartmentdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roshan.apartmentdemo.Helper.CustomAdapter;
import com.example.roshan.apartmentdemo.R;

public class flatlist extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flatlist);
        CustomAdapter adapter=new CustomAdapter(this, itemname, imgid,flatcity);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
}