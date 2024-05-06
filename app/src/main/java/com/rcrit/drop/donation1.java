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
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class donation1 extends AppCompatActivity {

    private TextView mBackTextView;
    private TextView mNameTextView;
    private TextView mTimeTextView;
    private TextView mLocationTextView;
    private TextView mBloodTextView;
    private TextView mBGTextView;
    private TextView mUnitTextView;
    private TextView mUTextView;
    private TextView mHospTextView;
    private TextView mHospNameTextView;
    private TextView mDescriptionTextView;
    private TextView mContactTextView;
    private TextView mNumberTextView;
    private Button mDonateButton;
    private ImageView mProfileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate1);
        initializeViews();

        mBackTextView.setOnClickListener(view -> startActivity(new Intent(this, homeadapter.class)));

        mNameTextView.setText("Sophia");
        mTimeTextView.setText(getString(R.string.time));
        mLocationTextView.setText("Chennai");
        mBloodTextView.setText(getString(R.string.blood));
        mBGTextView.setText(getString(R.string.bg));
        mUnitTextView.setText(getString(R.string.units));
        mUTextView.setText(getString(R.string.u));
        mHospTextView.setText(getString(R.string.hosp));
        mHospNameTextView.setText(getString(R.string.hospname));
        mDescriptionTextView.setText(getString(R.string.description));
        mContactTextView.setText(getString(R.string.contact));
        mNumberTextView.setText(getString(R.string.number));


        mDonateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmationDialog();
            }
        });

        mProfileImageView.setImageResource(R.drawable.pro);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.drop) {
                    // Code to perform on profile item click
                    startActivity(new Intent(getApplicationContext(), Postedrequests.class));
                    overridePendingTransition(0, 0);
                    return true;
                }if (item.getItemId() == R.id.home) {
                    // Code to perform on home item click
                    startActivity(new Intent(getApplicationContext(), homeadapter.class));
                    overridePendingTransition(0, 0);
                    return true;
                }if (item.getItemId() == R.id.profile) {
                    // Code to perform on message item click
                    startActivity(new Intent(getApplicationContext(), profile.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
    }

    private void initializeViews() {
        mBackTextView = findViewById(R.id.back);
        mNameTextView = findViewById(R.id.name);
        mTimeTextView = findViewById(R.id.time);
        mLocationTextView = findViewById(R.id.location);
        mBloodTextView = findViewById(R.id.blood);
        mBGTextView = findViewById(R.id.bg);
        mUnitTextView = findViewById(R.id.unit);
        mUTextView = findViewById(R.id.u);
        mHospTextView = findViewById(R.id.hosp);
        mHospNameTextView = findViewById(R.id.hospname);
        mDescriptionTextView = findViewById(R.id.description);
        mContactTextView = findViewById(R.id.contact);
        mNumberTextView = findViewById(R.id.number);
        mDonateButton = findViewById(R.id.bt);
        mProfileImageView = findViewById(R.id.prof);
    }

    private void showConfirmationDialog() {

        donateBlood();
    }

    private void donateBlood() {

        Intent intent = new Intent(this, donation2.class);
        startActivity(intent);
    }
}
