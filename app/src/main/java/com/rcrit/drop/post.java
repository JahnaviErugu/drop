package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class post extends AppCompatActivity {
    private Button postbutton;
    private EditText patientname, mobilenumber, hospname, purpose;
    private TextView Backhome;
    private Spinner bloodgroupspinner;
    private NumberPicker unitsPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        postbutton = findViewById(R.id.buttons);
        bloodgroupspinner = findViewById(R.id.blood_group_spinner);
        unitsPicker = findViewById(R.id.unitspicker);
        Backhome = findViewById(R.id.bhome);
        patientname = findViewById(R.id.username_editText);
        mobilenumber = findViewById(R.id.username_editText2);
        hospname = findViewById(R.id.username_editText3);
        purpose = findViewById(R.id.username_editText6);

        // Set the range for the number picker
        unitsPicker.setMinValue(1);
        unitsPicker.setMaxValue(10);

        // Add items to the blood group spinner
        String[] bloodGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        Spinner bloodGroupSpinner = findViewById(R.id.blood_group_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bloodGroups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSpinner.setAdapter(adapter);

        postbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String patientName = ((EditText) findViewById(R.id.username_editText)).getText().toString();
                String mobileNumber = ((EditText) findViewById(R.id.username_editText2)).getText().toString();
                String hospitalName = ((EditText) findViewById(R.id.username_editText3)).getText().toString();
                String bloodGroup = bloodgroupspinner.getSelectedItem().toString();
                int unitsRequired = unitsPicker.getValue();
                String purpose = ((EditText) findViewById(R.id.username_editText6)).getText().toString();

                // TODO: Send the request data to the server

                Intent intent = new Intent(post.this, alert2.class);
                startActivity(intent);
            }
        });
    }
}
