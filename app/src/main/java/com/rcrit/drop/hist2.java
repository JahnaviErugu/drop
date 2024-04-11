package com.rcrit.drop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class hist2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private hist1adapter adapter;
    private ArrayList<hist1model> hist1models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hist2);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclee);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data for RecyclerView
        hist1models = new ArrayList<>();
        hist1models.add(new hist1model("Selena Gomez", "Rainy Hospital, Chennai", "Requested on 2/3/2023", "Requested 2 units", "O+", R.drawable.pro));
        hist1models.add(new hist1model("David John Abraham", "Apollo Hospital, Chennai", "Requested on 2/3/2023", "Requested 2 units", "O-", R.drawable.pro2));
        hist1models.add(new hist1model("Selena Gomez", "Rainy Hospital, Chennai", "Requested on 2/3/2023", "Requested 2 units", "O+", R.drawable.pro));


        // Set up RecyclerView adapter
        adapter = new hist1adapter(this, hist1models);
        recyclerView.setAdapter(adapter);
    }
}
