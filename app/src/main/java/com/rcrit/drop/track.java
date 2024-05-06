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

    private int mTotalUnitsNeeded = 100;
    private int mCurrentUnitsProgress = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track);
        initializeViews();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.drop) {
                    startActivity(new Intent(getApplicationContext(), Postedrequests.class));
                    overridePendingTransition(0, 0);
                    return true;
                } if (item.getItemId() == R.id.home) {

                    startActivity(new Intent(getApplicationContext(), homeadapter.class));
                    overridePendingTransition(0, 0);
                    return true;
                } if (item.getItemId() == R.id.profile) {

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


        updateProgress();


        mCancelButton.setOnClickListener(view -> cancelRequest());
    }

    private void updateProgress() {

        int progressPercentage = (int) (((float) mCurrentUnitsProgress / mTotalUnitsNeeded) * 100);


        mProgressBar.setProgress(progressPercentage);
        mProgressTextView.setText(mCurrentUnitsProgress + " U / " + mTotalUnitsNeeded + " U");
    }

    private void cancelRequest() {

        mCurrentUnitsProgress = 0;
        updateProgress();


        runOnUiThread(() -> {

            mCancelButton.setVisibility(View.GONE);


            Toast.makeText(track.this, "Request canceled", Toast.LENGTH_SHORT).show();
        });
    }
}
