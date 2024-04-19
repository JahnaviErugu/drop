package com.rcrit.drop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class hist2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private hist2adapter adapter;
    private ArrayList<hist2model> hist2models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hist2);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data for RecyclerView
        hist2models = new ArrayList<>();
        hist2models.add(new hist2model("Selena Gomez", "Rainy Hospital, Chennai", "Donated on 2/3/2023", "Donated 2 units", "O+", R.drawable.pro));
        hist2models.add(new hist2model("David John Abraham", "Apollo Hospital, Chennai", "Donated on 2/3/2023", "Donated 2 units", "O-", R.drawable.pro2));
        hist2models.add(new hist2model("Selena Gomez", "Rainy Hospital, Chennai", "Donated on 2/3/2023", "Donated 2 units", "O+", R.drawable.pro));


        // Set up RecyclerView adapter
        adapter = new hist2adapter(this,hist2models);
        recyclerView.setAdapter(adapter);
    }
}
