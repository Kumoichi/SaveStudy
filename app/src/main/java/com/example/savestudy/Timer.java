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
    GifImageView gifimage, stopgif;
    private String subject, task;
    int elapsedTimeInSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        gifimage = findViewById(R.id.gifimage);
        stopgif = findViewById(R.id.stopgif);

        //getting subject and task string from PlanPage
        Intent intent = getIntent();
        subject = intent.getStringExtra("subject_one");
        task = intent.getStringExtra("task_one");

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
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
            elapsedTimeInSec = (int) ((SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000);

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
        intent.putExtra("subject_two", subject);
        intent.putExtra("task_two",task);
        startActivity(intent);
    }
}