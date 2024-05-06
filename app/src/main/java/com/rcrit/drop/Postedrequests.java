package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Postedrequests extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Postedrecycleviewadapter adapter;
    private ArrayList<dataclass> datamodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postedrequests);


        recyclerView = findViewById(R.id.precyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        datamodel = new ArrayList<>();
        datamodel.add(new dataclass("Sophia", "Rainy Hospital, Chennai", "Posted an hour ago", "2 units", "O+", R.drawable.pro));
        datamodel.add(new dataclass("David John", "Apollo Hospital, Chennai", "Posted 2 hours ago", "1 units", "O-", R.drawable.pro2));
        datamodel.add(new dataclass("Karthik N M", "Apollo Hospital, Chennai", "Posted an hour ago", "1 units", "A+", R.drawable.pro3));
        datamodel.add(new dataclass("Sophia", "Rainy Hospital, Chennai", "Posted an hour ago", "2 units", "O+", R.drawable.pro));


        adapter = new Postedrecycleviewadapter(this, datamodel);
        recyclerView.setAdapter(adapter);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.drop);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.drop) {

                    return true;
                }if (item.getItemId() == R.id.home) {

                    startActivity(new Intent(getApplicationContext(), homeadapter.class));
                    overridePendingTransition(0, 0);
                    return true;
                }if (item.getItemId() == R.id.profile) {

                    startActivity(new Intent(getApplicationContext(), profile.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
    }
}
