package com.example.n08demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
/**
 * The OptOne activity
 * <p>
 * This activity use to demonstrate basic pass
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 22/7/2023
 */
public class OptOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_one);
    }

    /**
     * back1 method
     * <p> Ending this activity & return
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void back1(View view) {
        Toast.makeText(this, "Did nothing, Just return", Toast.LENGTH_LONG).show();
        finish();
    }
}