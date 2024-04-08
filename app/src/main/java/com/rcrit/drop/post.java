package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class post extends AppCompatActivity {

    private Button postButton;
    private EditText patientNameEditText, mobileNumberEditText, hospitalNameEditText, purposeEditText;
    private Spinner bloodGroupSpinner;
    private NumberPicker unitsPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        // Initialize views
        postButton = findViewById(R.id.buttons);
        bloodGroupSpinner = findViewById(R.id.blood_group_spinner);
        unitsPicker = findViewById(R.id.unitspicker);
        patientNameEditText = findViewById(R.id.username_editText);
        mobileNumberEditText = findViewById(R.id.username_editText2);
        hospitalNameEditText = findViewById(R.id.username_editText3);
        purposeEditText = findViewById(R.id.username_editText6);

        // Set the range for the number picker
        unitsPicker.setMinValue(1);
        unitsPicker.setMaxValue(10);

        // Add items to the blood group spinner
        String[] bloodGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bloodGroups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSpinner.setAdapter(adapter);

        // Handle post button click
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve input values
                String patientName = patientNameEditText.getText().toString().trim();
                String mobileNumber = mobileNumberEditText.getText().toString().trim();
                String hospitalName = hospitalNameEditText.getText().toString().trim();
                String bloodGroup = bloodGroupSpinner.getSelectedItem().toString();
                int unitsRequired = unitsPicker.getValue();
                String purpose = purposeEditText.getText().toString().trim();

                // Validate input fields
                if (isValidInput(patientName, mobileNumber, hospitalName, purpose)) {
                    // TODO: Send the request data to the server

                    // Show success message and navigate to next activity
                    Toast.makeText(post.this, "Request posted successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(post.this, alert2.class);
                    startActivity(intent);
                } else {
                    // Display error message for invalid input
                    Toast.makeText(post.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidInput(String patientName, String mobileNumber, String hospitalName, String purpose) {
        // Validate input fields
        return !TextUtils.isEmpty(patientName)
                && !TextUtils.isEmpty(mobileNumber)
                && !TextUtils.isEmpty(hospitalName)
                && !TextUtils.isEmpty(purpose);
    }
}
