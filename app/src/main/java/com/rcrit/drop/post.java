package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class post extends AppCompatActivity {

    private Button postButton;
    private EditText patientNameEditText, mobileNumberEditText, hospitalNameEditText, purposeEditText, unitsEditText;
    private Spinner bloodGroupSpinner;
    private ImageView add, remove;

    private TextView mBackHomeButton;
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
        mBackHomeButton = findViewById(R.id.bhome);


        String[] bloodGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bloodGroups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSpinner.setAdapter(adapter);


        setUnitsEditText(unitsEditText);
        mBackHomeButton.setOnClickListener(view -> startActivity(new Intent(this, homeadapter.class)));


        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String patientName = patientNameEditText.getText().toString().trim();
                String mobileNumber = mobileNumberEditText.getText().toString().trim();
                String hospitalName = hospitalNameEditText.getText().toString().trim();
                String bloodGroup = bloodGroupSpinner.getSelectedItem().toString();
                String purpose = purposeEditText.getText().toString().trim();


                if (isValidInput(patientName, mobileNumber, hospitalName, purpose)) {



                    Toast.makeText(post.this, "Request posted successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(post.this, alert2.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(post.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setUnitsEditText(final EditText unitsEditText) {

        unitsEditText.setText(String.valueOf(number));


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                unitsEditText.setText(String.valueOf(number));
            }
        });


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

        return !TextUtils.isEmpty(patientName)
                && !TextUtils.isEmpty(mobileNumber)
                && !TextUtils.isEmpty(hospitalName)
                && !TextUtils.isEmpty(purpose);
    }

}
