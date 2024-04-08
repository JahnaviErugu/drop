package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate1);
        initializeViews();

        mBackTextView.setOnClickListener(view -> startActivity(new Intent(this, homeadapter.class)));

        // Set your desired text for the views
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

        // Set click listener for donate button
        mDonateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show confirmation dialog before proceeding with donation
                showConfirmationDialog();
            }
        });

        // Set the image for the profile
        mProfileImageView.setImageResource(R.drawable.pro);
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
        mCardView = findViewById(R.id.cardView);
    }

    private void showConfirmationDialog() {
        // Implement your custom confirmation dialog here
        // For example:
        // AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // builder.setMessage("Are you sure you want to donate?");
        // builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        //     @Override
        //     public void onClick(DialogInterface dialogInterface, int i) {
        //         // Proceed with donation
        //         donateBlood();
        //     }
        // });
        // builder.setNegativeButton("No", null);
        // builder.show();

        // For simplicity, directly call donateBlood() without a confirmation dialog
        donateBlood();
    }

    private void donateBlood() {
        // Add logic to handle the donation process
        // For example, update UI to reflect donation status and navigate to donation2 activity
        Intent intent = new Intent(this, donation2.class);
        startActivity(intent);
    }
}
