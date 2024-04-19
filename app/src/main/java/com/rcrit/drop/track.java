package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class track extends AppCompatActivity {

    private TextView mBackHomeButton;
    private ImageView mProfileImageView;
    private TextView mNameTextView;
    private TextView mLocationTextView;
    private TextView mPostedTextView;
    private TextView mUnitsTextView;
    private TextView mBloodGroupTextView;
    private ProgressBar mProgressBar;
    private TextView mProgressTextView;
    private ImageView mCancelButton;

    private int mTotalUnitsNeeded = 100; // Total units needed for the request
    private int mCurrentUnitsProgress = 50; // Current units collected

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track);
        initializeViews();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.drop);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.drop) {
                    // Code to perform on home item click
                    return true;
                } if (item.getItemId() == R.id.home) {
                    // Code to perform on profile item click
                    startActivity(new Intent(getApplicationContext(), homeadapter.class));
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

        mBackHomeButton.setOnClickListener(view -> startActivity(new Intent(this, homeadapter.class)));
    }

    private void initializeViews() {
        mBackHomeButton = findViewById(R.id.backhome);
        mProfileImageView = findViewById(R.id.prof);
        mNameTextView = findViewById(R.id.name);
        mLocationTextView = findViewById(R.id.loc);
        mPostedTextView = findViewById(R.id.time);
        mUnitsTextView = findViewById(R.id.units);
        mBloodGroupTextView = findViewById(R.id.Bg);
        mProgressBar = findViewById(R.id.progressBar);
        mProgressTextView = findViewById(R.id.textViewProgress);
        mCancelButton = findViewById(R.id.imageViewCancel);

        mProfileImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pro));
        mNameTextView.setText("Sophia");
        mLocationTextView.setText("Rainy Hospital, Chennai");
        mPostedTextView.setText("Posted 2 units");
        mUnitsTextView.setText("Required: " + mTotalUnitsNeeded + " units");
        mBloodGroupTextView.setText("O+");

        // Update progress bar and progress text
        updateProgress();

        // Set a click listener for the cancel button
        mCancelButton.setOnClickListener(view -> cancelRequest());
    }

    private void updateProgress() {
        // Calculate progress percentage
        int progressPercentage = (int) (((float) mCurrentUnitsProgress / mTotalUnitsNeeded) * 100);

        // Update progress bar and progress text
        mProgressBar.setProgress(progressPercentage);
        mProgressTextView.setText(mCurrentUnitsProgress + " U / " + mTotalUnitsNeeded + " U");
    }

    private void cancelRequest() {
        // Add logic to handle request cancellation (e.g., call API to cancel request)

        // Simulate request cancellation by resetting progress
        mCurrentUnitsProgress = 0;
        updateProgress();

        // Run the UI update task on the main thread
        runOnUiThread(() -> {
            // Hide the cancel button
            mCancelButton.setVisibility(View.GONE);

            // Show a message indicating that the request was canceled
            Toast.makeText(track.this, "Request canceled", Toast.LENGTH_SHORT).show();
        });
    }
}
