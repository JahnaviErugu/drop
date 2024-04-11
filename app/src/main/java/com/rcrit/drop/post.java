package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class post extends AppCompatActivity {

    private Button postButton;
    private EditText patientNameEditText, mobileNumberEditText, hospitalNameEditText, purposeEditText, unitsEditText;
    private Spinner bloodGroupSpinner;
    private ImageView add, remove;
    int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        // Initialize views
        postButton = findViewById(R.id.buttons);
        bloodGroupSpinner = findViewById(R.id.blood_group_spinner);
        patientNameEditText = findViewById(R.id.username_editText);
        mobileNumberEditText = findViewById(R.id.username_editText2);
        hospitalNameEditText = findViewById(R.id.username_editText3);
        purposeEditText = findViewById(R.id.username_editText6);
        unitsEditText = findViewById(R.id.username_editText5);
        add = findViewById(R.id.add);
        remove = findViewById(R.id.remove);

        // Add items to the blood group spinner
        String[] bloodGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bloodGroups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSpinner.setAdapter(adapter);

        // Set up units functionality
        setUnitsEditText(unitsEditText);

        // Handle post button click
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve input values
                String patientName = patientNameEditText.getText().toString().trim();
                String mobileNumber = mobileNumberEditText.getText().toString().trim();
                String hospitalName = hospitalNameEditText.getText().toString().trim();
                String bloodGroup = bloodGroupSpinner.getSelectedItem().toString();
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

    private void setUnitsEditText(final EditText unitsEditText) {
        // Initialize number of units and set initial value
        unitsEditText.setText(String.valueOf(number));

        // Handle add button click
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                unitsEditText.setText(String.valueOf(number));
            }
        });

        // Handle remove button click
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number > 1) {
                    number--;
                    unitsEditText.setText(String.valueOf(number));
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
