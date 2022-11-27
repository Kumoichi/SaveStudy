package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageButton;
import pl.droidsonroids.gif.GifImageView;

public class Timer extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private int currentTime;
    private boolean running;
    TextView textView, subject_id, todotask_id;
    GifImageView gifimage, stopgif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        gifimage = findViewById(R.id.gifimage);
        stopgif = findViewById(R.id.stopgif);
        subject_id = findViewById(R.id.subject_id);
        todotask_id = findViewById(R.id.todotask_id);

        Intent intent = getIntent();
        String task = intent.getStringExtra("task_one");
        String subject = intent.getStringExtra("subject_one");
        subject_id.setText(subject);
        todotask_id.setText(task);


        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 100000) {

                }
            }
        });
    }

    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
            stopgif.setVisibility(View.GONE);
            gifimage.setVisibility(View.VISIBLE);

        }
    }

    public void pauseChronometer(View v) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
            gifimage.setVisibility(View.GONE);
            stopgif.setVisibility(View.VISIBLE);

        }
    }

    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    public void displayChronometer(View view) {
        //textView.setText(chronometer.getText());
        int elapsedTimeInSec = (int) ((SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("timedata", elapsedTimeInSec);

        startActivity(intent);
    }
}