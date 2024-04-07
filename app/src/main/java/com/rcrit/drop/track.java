package com.rcrit.drop;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.widget.Toast;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track);
        initializeViews();

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

        // Set your desired text for the views
        mNameTextView.setText("Sophia");
        mLocationTextView.setText("Rainy Hospital, Chennai");
        mPostedTextView.setText("2 units");
        mUnitsTextView.setText("Required: 2 units");
        mBloodGroupTextView.setText("O+");

        // Set progress to an initial value, e.g., 50%
        mProgressBar.setProgress(50);
        mProgressTextView.setText("50 U / 100 U");

        // Set a click listener for the cancel button
        mCancelButton.setOnClickListener(view -> cancelRequest());
    }
    private void cancelRequest() {
        // Add the implementation for canceling the request

        // Run the UI update task on the main thread
        runOnUiThread(updateUIRunnable);
    }
    Runnable updateUIRunnable = new Runnable() {
        @Override
        public void run() {
            // Update the UI to reflect the cancellation of the request.
            // For example, you can disable the progress bar, hide the cancel button,
            // or show a message indicating that the request was canceled.

            // Disable the progress bar
            mProgressBar.setEnabled(false);

            // Hide the cancel button
            mCancelButton.setVisibility(View.GONE);

            // Show a message
            Toast.makeText(track.this, "Request canceled", Toast.LENGTH_SHORT).show();
        }
    };
}
