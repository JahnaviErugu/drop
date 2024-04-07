package com.rcrit.drop;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class splash1 extends AppCompatActivity {
    private static int SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash1);

        // Using a Handler to delay the transition to Splashscreen2
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start your next activity here
                startActivity(new Intent(splash1.this, splash2.class));
                // Close this activity
                finish();
            }
        }, SPLASH_SCREEN_DELAY);
    }
}
