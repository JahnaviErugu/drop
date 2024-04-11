package com.rcrit.drop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

import java.util.Calendar;

public class signup extends AppCompatActivity {

    private EditText emailEditText, passwordEditText, birthEditText;
    private CheckBox policyCheckBox;
    private Button signUpButton;
    private TextView googleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // Initialize views
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        birthEditText = findViewById(R.id.birth);
        policyCheckBox = findViewById(R.id.policy);
        signUpButton = findViewById(R.id.button);
        googleTextView = findViewById(R.id.texticon);

        // Set click listener for sign-up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get input values
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String birthDate = birthEditText.getText().toString().trim();
                boolean agreePolicy = policyCheckBox.isChecked();

                // Validate input fields
                if (isValidEmail(email) && isValidPassword(password) && isValidBirthDate(birthDate) && agreePolicy) {
                    // Proceed with sign-up
                    // Add your sign-up logic here (e.g., create new user account)
                    Toast.makeText(signup.this, "Sign-up successful!", Toast.LENGTH_SHORT).show();
                    // Navigate to home or next activity
                    Intent intent = new Intent(signup.this, Login.class);
                    startActivity(intent);
                } else {
                    // Display error message for invalid input
                    Toast.makeText(signup.this, "Please fill in all fields and agree to the policy", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for birth date edit text to show date picker
        birthEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show date picker dialog
                showDatePickerDialog();
            }
        });


    }

    // Method to validate email format
    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Method to validate password strength
    private boolean isValidPassword(String password) {
        return password.length() >= 6; // Example: Password must be at least 6 characters
    }

    // Method to validate date of birth format
    private boolean isValidBirthDate(String birthDate) {
        return !TextUtils.isEmpty(birthDate);
    }

    // Method to show date picker dialog
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                signup.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Set selected date in edit text
                        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                        birthEditText.setText(date);
                    }
                },
                year, month, dayOfMonth);

        datePickerDialog.show();
    }
}


