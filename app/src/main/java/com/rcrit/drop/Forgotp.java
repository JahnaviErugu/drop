package com.rcrit.drop;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        mVerifyButton.setOnClickListener(view -> verify(view));
    }

    public void verify(View view) {

            startActivity(new Intent(this, alert1.class));

    }
}