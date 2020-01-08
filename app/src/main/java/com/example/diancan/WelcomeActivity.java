package com.example.diancan;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class WelcomeActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, DiancanActivity.class);
                WelcomeActivity.this.startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);

    }
}
