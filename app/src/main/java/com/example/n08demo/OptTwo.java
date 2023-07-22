package com.example.n08demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The OptTwo activity
 * <p>
 * This activity use to demonstrate pass with data receiving
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 22/7/2023
 */
public class OptTwo extends AppCompatActivity {

    private TextView tV;
    private int count;
    Intent gi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_two);

        tV = findViewById(R.id.tV);

        gi2 = getIntent();
        count = gi2.getIntExtra("count2",0);

        tV.setText("This is the "+count+" activity pass");
    }

    /**
     * back2 method
     * <p> Ending this activity & return
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void back2(View view) {
        Toast.makeText(this, "Return after "+count+" activities passes.", Toast.LENGTH_LONG).show();
        finish();
    }
}