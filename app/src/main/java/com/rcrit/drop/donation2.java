package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class donation2 extends AppCompatActivity {

    private TextView mCongratsTextView;
    private TextView mCongratsDescriptionTextView;
    private TextView mDonationIdTextView;
    private ImageView mHospitalImageView;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate2);
        initializeViews();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    // Code to perform on home item click
                    startActivity(new Intent(getApplicationContext(), homeadapter.class));
                    overridePendingTransition(0, 0);
                    return true;
                } if (item.getItemId() == R.id.drop) {
                    // Code to perform on profile item click
                    startActivity(new Intent(getApplicationContext(), Postedrequests.class));
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

        mBackButton.setOnClickListener(view -> startActivity(new Intent(this, homeadapter.class)));
    }

    private void initializeViews() {
        mCongratsTextView = findViewById(R.id.congo);
        mCongratsDescriptionTextView = findViewById(R.id.congod);
        mDonationIdTextView = findViewById(R.id.donid);
        mHospitalImageView = findViewById(R.id.hosp);
        mBackButton = findViewById(R.id.bt2);

        // Set the text for the congratulations and description
        mCongratsTextView.setText("Congratulations!");
        mCongratsDescriptionTextView.setText(getString(R.string.congod));

        // Set the image for the hospital
        mHospitalImageView.setImageDrawable(getResources().getDrawable(R.drawable.hosp));

        // Generate a random donation ID (for demonstration purposes)
        String donationId = generateDonationId();
        mDonationIdTextView.setText("Donation ID: " + donationId);
    }

    private String generateDonationId() {

        return "DN" + (int) (Math.random() * 1000000);
    }

}
