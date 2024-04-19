package com.rcrit.drop;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import java.util.ArrayList;
import com.google.android.material.bottomnavigation.BottomNavigationView;




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
        requestModels.add(new requestmodel("David John", "Apollo Hospital, Chennai", "Posted 2 hours ago", "1 units", "O-", R.drawable.pro2));
        requestModels.add(new requestmodel("Karthik N M", "Apollo Hospital, Chennai", "Posted an hour ago", "1 units", "A+", R.drawable.pro3));

        // Set up RecyclerView adapter
        adapter = new RecycleViewAdapter(this, requestModels);
        recyclerView.setAdapter(adapter);

        TextView postRequest = findViewById(R.id.postbutton);

        postRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle post request button click
                // For example, navigate to a new activity to post a request
                Intent intent = new Intent(homeadapter.this, post.class);
                startActivity(intent);
            }
        });

        TextView trackRequestButton = findViewById(R.id.button2);
        trackRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle track request button click
                // For example, navigate to a new activity to track requests
                Intent intent = new Intent(homeadapter.this, track.class);
                startActivity(intent);
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    // Code to perform on home item click
                    return true;
                } if (item.getItemId() == R.id.drop) {
                    // Code to perform on profile item click
                    startActivity(new Intent(getApplicationContext(), track.class));
                    overridePendingTransition(0, 0);
                    return true;
                } if (item.getItemId() == R.id.profile) {
                        // Code to perform on message item click
                        startActivity(new Intent(getApplicationContext(), profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
    public void onViewMoreClicked(View view) {
        // Handle "View more" click event
        // For example, navigate to a new activity to view more requests
        Intent intent = new Intent(homeadapter.this, Postedrequests.class);
        startActivity(intent);
    }

}
