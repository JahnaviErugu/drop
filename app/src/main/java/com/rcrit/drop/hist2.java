package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class hist2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private hist2adapter adapter;

    private TextView requesthist;
    private ArrayList<hist2model> hist2models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hist2);


        recyclerView = findViewById(R.id.recycles);
        requesthist = findViewById(R.id.hist1);
        requesthist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(hist2.this, hist1.class);
                startActivity(intent);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        hist2models = new ArrayList<>();
        hist2models.add(new hist2model("Selena Gomez", "Rainy Hospital, Chennai", "Donated on 2/3/2023", "Donated 2 units", "O+", R.drawable.pro));
        hist2models.add(new hist2model("David John Abraham", "Apollo Hospital, Chennai", "Donated on 2/3/2023", "Donated 2 units", "O-", R.drawable.pro2));
        hist2models.add(new hist2model("Selena Gomez", "Rainy Hospital, Chennai", "Donated on 2/3/2023", "Donated 2 units", "O+", R.drawable.pro));



        adapter = new hist2adapter(this,hist2models);
        recyclerView.setAdapter(adapter);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {

                    startActivity(new Intent(getApplicationContext(), homeadapter.class));
                    overridePendingTransition(0, 0);
                    return true;
                } if (item.getItemId() == R.id.drop) {

                    startActivity(new Intent(getApplicationContext(), Postedrequests.class));
                    overridePendingTransition(0, 0);
                    return true;
                } if (item.getItemId() == R.id.profile) {

                    startActivity(new Intent(getApplicationContext(), profile.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
    }
}
