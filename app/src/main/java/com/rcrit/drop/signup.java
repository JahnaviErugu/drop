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

import java.util.Calendar;

public class signup extends AppCompatActivity {
        private EditText emailEditText, passwordEditText, birthEditText;
        private CheckBox policyCheckBox;
        private Button signUpButton;
        private TextView googletext;

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
            googletext = findViewById(R.id.texticon);
            signUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(signup.this, homeadapter.class);
                    startActivity(intent);
                }
            });


            // Set up click listener for the date of birth edit text
            birthEditText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Show date picker dialog
                    DatePickerDialog datePickerDialog = new DatePickerDialog(signup.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            // Set date in edit text
                            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                            birthEditText.setText(date);
                        }
                    }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                    datePickerDialog.show();
                }
            });
        }
    }

