package com.rcrit.drop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ob1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ob1);

    }

    public void skip1(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }

    public void f1(View view) {
        Intent intent = new Intent(this, ob2.class);
        startActivity(intent);
    }
}
