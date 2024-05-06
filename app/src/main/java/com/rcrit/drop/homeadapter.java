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

public class homeadapter extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;
    private ArrayList<requestmodel> requestModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        recyclerView = findViewById(R.id.hrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestModels = new ArrayList<>();
        requestModels.add(new requestmodel("Sophia", "Rainy Hospital, Chennai", "Posted an hour ago", "2 units", "O+", R.drawable.pro));
        requestModels.add(new requestmodel("David John", "Apollo Hospital, Chennai", "Posted 2 hours ago", "1 units", "O-", R.drawable.pro2));
        requestModels.add(new requestmodel("Karthik N M", "Apollo Hospital, Chennai", "Posted an hour ago", "1 units", "A+", R.drawable.pro3));


        adapter = new RecycleViewAdapter(this, requestModels);
        recyclerView.setAdapter(adapter);

        TextView postRequest = findViewById(R.id.postbutton);
        postRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(homeadapter.this, post.class);
                startActivity(intent);
            }
        });

        TextView trackRequestButton = findViewById(R.id.button2);
        trackRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                    return true;
                } else if (item.getItemId() == R.id.drop) {

                    startActivity(new Intent(getApplicationContext(), Postedrequests.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (item.getItemId() == R.id.profile) {

                    startActivity(new Intent(getApplicationContext(), profile.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
    }

    public void onViewMoreClicked(View view) {

        Intent intent = new Intent(homeadapter.this, Postedrequests.class);
        startActivity(intent);
    }


}
