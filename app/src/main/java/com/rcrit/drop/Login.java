package com.rcrit.drop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    private Button loginButton;
    private TextView forgotTextView;
    private EditText Email;
    private EditText password;
    private TextView signupTextView;
    private TextView GoogleTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginButton = findViewById(R.id.button);
        forgotTextView = findViewById(R.id.forgot1);
        signupTextView = findViewById(R.id.signup);
        Email = findViewById(R.id.email);
        password =  findViewById(R.id.password);
        GoogleTextView =  findViewById(R.id.textgoogle);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = Email.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();

                // Perform validation (e.g., check against hardcoded values for demonstration)
                if (enteredEmail.equals("test@example.com") && enteredPassword.equals("password123")) {
                    // Authentication successful, navigate to homeadapter activity
                    Intent intent = new Intent(Login.this, homeadapter.class);
                    startActivity(intent);
                } else if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Authentication failed, show error message or handle accordingly
                    Toast.makeText(Login.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        forgotTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle forgot password click
                Intent intent = new Intent(Login.this, Forgotp.class);
                startActivity(intent);

            }
        });

        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle sign up button click
                Intent intent = new Intent(Login.this, signup.class);
                startActivity(intent);
            }
        });
    }
}