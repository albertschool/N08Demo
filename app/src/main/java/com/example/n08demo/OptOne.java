package com.example.n08demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class OptOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_one);
    }

    public void back1(View view) {
        Toast.makeText(this, "Did nothing, Just return", Toast.LENGTH_LONG).show();
        finish();
    }
}