package com.example.n08demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    public void addcount(View view) {
        count++;
        tV3.setText("There were "+count+" presses");
    }

    public void back3(View view) {
//        Intent gi3 = getIntent();
        gi3.putExtra("count",count);
        setResult(RESULT_OK,gi3);
        finish();
    }
}