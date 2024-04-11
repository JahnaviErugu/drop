package com.rcrit.drop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class alert2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert2); // Correct the layout resource name (assuming it's activity_alert2)

        // This method might be called from a button click or other event
        // For example, you can call showCustomAlertDialog() from a button click
    }

    public void showCustomAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.alert2, null); // Use a custom dialog layout

        TextView messageTextView = dialogView.findViewById(R.id.titleTextView);
        Button loginButton = dialogView.findViewById(R.id.loginButton);

        messageTextView.setText("Request posted successfully!");

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login button click
                // You can add your login logic here
                Intent intent = new Intent(alert2.this, homeadapter.class);
                startActivity(intent);
                dialog.dismiss(); // Dismiss the dialog after login
            }
        });

        dialog.show();
    }
}
