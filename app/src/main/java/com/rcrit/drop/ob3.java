package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ob3 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ob3);


    }

    public void f3(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
