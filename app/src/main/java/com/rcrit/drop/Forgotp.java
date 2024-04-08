package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Forgotp extends AppCompatActivity {

    private EditText mEmailEditText;
    private Button mVerifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgpass);
        initializeViews();
    }

    private void initializeViews() {
        mEmailEditText = findViewById(R.id.emails);
        mVerifyButton = findViewById(R.id.verify);

        mVerifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailEditText.getText().toString().trim();

                if (isValidEmail(email)) {
                    // Valid email, proceed with verification
                    // Add your verification logic here (e.g., send verification email)

                    // For demonstration, navigate to alert1 activity on verification
                    startActivity(new Intent(Forgotp.this, alert1.class));
                } else {
                    // Invalid email, show error message
                    Toast.makeText(Forgotp.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
