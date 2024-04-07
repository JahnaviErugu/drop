package com.rcrit.drop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


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
    }

    public void back(View view) {
        startActivity(new Intent(this, homeadapter.class));
    }
}
