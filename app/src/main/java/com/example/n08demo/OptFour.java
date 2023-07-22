package com.example.n08demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * The OptFour activity
 * <p>
 * This activity use to demonstrate pass with data receiving & returning by ActivityLauncher
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 22/7/2023
 */
public class OptFour extends AppCompatActivity {

    private TextView tV4;
    private int count;
    private Intent gi4;
    private static final int RESULT_CODE = 104;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_four);

        tV4 = (TextView) findViewById(R.id.tV4);

        gi4 = getIntent();
        count = gi4.getIntExtra("count3",-1);

        tV4.setText("There were "+count+" presses");
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
        tV4.setText("There were "+count+" presses");
    }

    /**
     * back4 method
     * <p> Ending this activity & return with data
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void back4(View view) {
        gi4.putExtra("count",count);
        setResult(RESULT_CODE,gi4);
        finish();
    }
}