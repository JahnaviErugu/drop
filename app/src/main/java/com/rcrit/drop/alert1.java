package com.rcrit.drop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class alert1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert1);
    }

    public void showCustomAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.alert1, null);

        TextView titleTextView = dialogView.findViewById(R.id.titleTextView);
        TextView messageTextView = dialogView.findViewById(R.id.messageTextView);
        Button loginButton = dialogView.findViewById(R.id.loginButton);

        titleTextView.setText("Check your inbox!");
        messageTextView.setText("To reset your password, please check your email.");

        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login button click
                Intent intent = new Intent(alert1.this, Login.class);
                startActivity(intent);
                dialog.dismiss(); // Dismiss the dialog after login
            }
        });

        dialog.show();
    }
}
