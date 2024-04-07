package com.rcrit.drop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;




public class homeadapter extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;
    private ArrayList<requestmodel> requestModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.hrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data for RecyclerView
        requestModels = new ArrayList<>();
        requestModels.add(new requestmodel("Sophia", "Rainy Hospital, Chennai", "Posted an hour ago", "2 units", "O+", R.drawable.pro));

        // Set up RecyclerView adapter
        adapter = new RecycleViewAdapter(this, requestModels);
        recyclerView.setAdapter(adapter);
    }

}
