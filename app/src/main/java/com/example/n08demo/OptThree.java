package com.example.n08demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * The OptThree activity
 * <p>
 * This activity use to demonstrate pass with data receiving & returning by deprecated method
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 22/7/2023
 */
public class OptThree extends AppCompatActivity {

    private TextView tV3;
    private int count;
    private Intent gi3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_three);

        tV3 = (TextView) findViewById(R.id.tV3);

        gi3 = getIntent();
        count = gi3.getIntExtra("count3",0);

        tV3.setText("There were "+count+" presses");
    }

    /**
     * addCount method
     * <p> Count clicks on the button
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void addCount(View view) {
        count++;
        tV3.setText("There were "+count+" presses");
    }

    /**
     * back3 method
     * <p> Ending this activity & return with data
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void back3(View view) {
        gi3.putExtra("count",count);
        setResult(RESULT_OK,gi3);
        finish();
    }
}