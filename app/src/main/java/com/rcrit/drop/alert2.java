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
        setContentView(R.layout.alert2);
    }

    public void showCustomAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.alert2, null);

        TextView messageTextView = dialogView.findViewById(R.id.titleTextView);
        Button loginButton = dialogView.findViewById(R.id.loginButton);

        messageTextView.setText("Request posted successfully!");

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(alert2.this, homeadapter.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
