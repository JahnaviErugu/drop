package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;

public class profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        ShapeableImageView profileImageView = findViewById(R.id.profileCircleImageView);
        TextView usernameTextView = findViewById(R.id.usernameTextView);
        TextView accountTextView = findViewById(R.id.Account);
        TextView locationTextView = findViewById(R.id.locationTextView);
        TextView settingsTextView = findViewById(R.id.settingsTextview);
        TextView helpTextView = findViewById(R.id.helptextview);
        TextView inviteTextView = findViewById(R.id.invitetextview);
        TextView appVersionTextView = findViewById(R.id.Appversion);


        usernameTextView.setText("Godson P");
        accountTextView.setText("Account");
        locationTextView.setText("Location");
        settingsTextView.setText("Settings");
        helpTextView.setText("Help");
        inviteTextView.setText("Invite a Friend");
        appVersionTextView.setText("App Version 1.0");


        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(profile.this, hist1.class);
                startActivity(intent);
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.profile) {

                    return true;
                } if (item.getItemId() == R.id.home) {

                    startActivity(new Intent(getApplicationContext(), homeadapter.class));
                    overridePendingTransition(0, 0);
                    return true;
                } if (item.getItemId() == R.id.drop) {

                    startActivity(new Intent(getApplicationContext(), track.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });

    }
}
