package com.rcrit.drop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class hist1 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private hist1adapter adapter;

    private TextView donationhist;
    private ArrayList<hist1model> hist1models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hist1);

        recyclerView = findViewById(R.id.recycle);
        donationhist = findViewById(R.id.hist2);
        donationhist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hist1.this, hist2.class);
                startActivity(intent);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hist1models = new ArrayList<>();
        hist1models.add(new hist1model("Selena Gomez", "Rainy Hospital, Chennai", "Requested on 2/3/2023", "Requested 2 units", "O+", R.drawable.pro));
        hist1models.add(new hist1model("David John Abraham", "Apollo Hospital, Chennai", "Requested on 2/3/2023", "Requested 2 units", "O-", R.drawable.pro2));
        hist1models.add(new hist1model("Selena Gomez", "Rainy Hospital, Chennai", "Requested on 2/3/2023", "Requested 2 units", "O+", R.drawable.pro));


        adapter = new hist1adapter(this, hist1models);
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
