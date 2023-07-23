package com.example.n08demo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
/**
 * The Main activity
 * <p>
 * A basic demo application to demonstrate pass between activities:
 * 1. basic pass
 * 2. pass that include data sending
 * 3. pass that include data sending & receiving back
 * 4. pass that include data sending & receiving back with Activity Launcher
 * <p>
 * This activity is the home activity to pass between
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 22/7/2023
 */
public class MainActivity extends AppCompatActivity {

    private TextView tV1;
    private int count2=0, count3=0;
    private static final int REQUEST_CODE = 100;
    private static final int RESULT_CODE = 104;
    private final ActivityResultLauncher<Intent> activityLauncher =
            registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                /**
                 * onActivityResult method
                 * <p> Method triggered by other activity returning result
                 * </p>
                 *
                 * @param result the ActivityResult returned object
                 */
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

    /**
     * opt1 method
     * <p> Demonstrate basic pass, no data send or receive
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void opt1(View view) {
        Intent si = new Intent(this, OptOne.class);
        startActivity(si);
    }

    /**
     * opt2 method
     * <p> Demonstrate pass with data send
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void opt2(View view) {
        count2++;
        Intent si = new Intent(this, OptTwo.class);
        si.putExtra("count2", count2);
        startActivity(si);
    }

    /**
     * addCount method
     * <p> Count clicks on the button
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void addCount(View view) {
        count3++;
        tV1.setText("There were "+count3+" presses");
    }

    /**
     * opt3 method
     * <p> Demonstrate pass with data send & waiting for data back
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void opt3(View view) {
        Intent si = new Intent(this, OptThree.class);
        si.putExtra("count3", count3);
        startActivityForResult(si,REQUEST_CODE);
    }

    /**
     * onActivityResult method
     * <p> Method triggered by other activity returning result
     * </p>
     *
     * @param requestCode the request code triggered the activity
     * @param resultCode the status of the activity result
     * @param data_back the Intent returned object
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data_back) {
        super.onActivityResult(requestCode, resultCode, data_back);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data_back != null) {
                    count3 = data_back.getIntExtra("count", -1);
                    tV1.setText("There were " + count3 + " presses");
                }
            }
        }
    }

    /**
     * opt4 method
     * <p> Demonstrate pass with data send & waiting for data back using Activity Launcher
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void opt4(View view) {
        Intent si = new Intent(this, OptFour.class);
        si.putExtra("count3", count3);
        activityLauncher.launch(si);
    }
}