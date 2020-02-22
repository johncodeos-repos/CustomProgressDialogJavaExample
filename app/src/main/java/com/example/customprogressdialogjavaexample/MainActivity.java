package com.example.customprogressdialogjavaexample;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button startBtn;
    CustomProgressBar progressBar = new CustomProgressBar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.start_btn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show progress bar
                progressBar.show(MainActivity.this, "Please Wait...");

                Handler handler = new Handler();
                handler.postDelayed((new Runnable() {
                    public final void run() {
                        progressBar.dialog.dismiss();
                    }
                }), 4000);
            }
        });

    }
}
