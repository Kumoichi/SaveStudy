package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String totalVal = getIntent().getStringExtra("key");

        result = findViewById(R.id.total_val);
        result.setText(totalVal);
    }
}