package com.example.n08demo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tV1;
    private int count2=0, count3=0;
    private static final int REQUEST_CODE = 100;
    private static final int RESULT_CODE = 104;
    private ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_CODE){
                        Intent ri = result.getData();
                        if (ri != null) {
                            count3 = ri.getIntExtra("count", -1);
                            tV1.setText("There were " + count3 + " presses");
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tV1 = findViewById(R.id.tV1);
        tV1.setText("There were "+count3+" presses");
    }

    public void opt1(View view) {
        Intent si = new Intent(this, OptOne.class);
        startActivity(si);
    }

    public void opt2(View view) {
        count2++;
        Intent si = new Intent(this, OptTwo.class);
        si.putExtra("count2", count2);
        startActivity(si);
    }

    public void addcount(View view) {
        count3++;
        tV1.setText("There were "+count3+" presses");
    }

    public void opt3(View view) {
        Intent si = new Intent(this, OptThree.class);
        si.putExtra("count3", count3);
        startActivityForResult(si,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int source, int result, @Nullable Intent data_back) {
        super.onActivityResult(source, result, data_back);
        if (source == REQUEST_CODE) {
            if (result == Activity.RESULT_OK) {
                if (data_back != null) {
                    count3 = data_back.getIntExtra("count", -1);
                    tV1.setText("There were " + count3 + " presses");
                }
            }
        }
    }

    public void opt4(View view) {
        Intent si = new Intent(this, OptFour.class);
        si.putExtra("count3", count3);
        activityLauncher.launch(si);
    }
}