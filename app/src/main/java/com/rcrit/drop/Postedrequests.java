package com.rcrit.drop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Postedrequests extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Postedrecycleviewadapter adapter;
    private ArrayList<dataclass> datamodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postedrequests);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.precyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data for RecyclerView
        datamodel = new ArrayList<>();
        datamodel.add(new dataclass("Sophia", "Rainy Hospital, Chennai", "Posted an hour ago", "2 units", "O+", R.drawable.pro));
        datamodel.add(new dataclass("David John", "Apollo Hospital, Chennai", "Posted 2 hours ago", "1 units", "O-", R.drawable.pro2));
        datamodel.add(new dataclass("Karthik N M", "Apollo Hospital, Chennai", "Posted an hour ago", "1 units", "A+", R.drawable.pro3));
        datamodel.add(new dataclass("Sophia", "Rainy Hospital, Chennai", "Posted an hour ago", "2 units", "O+", R.drawable.pro));

        // Set up RecyclerView adapter
        adapter = new Postedrecycleviewadapter(this, datamodel);
        recyclerView.setAdapter(adapter);
    }
}
