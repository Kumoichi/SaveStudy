package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DataMenu extends AppCompatActivity {

    Button view_btn, bar_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_menu);

        view_btn = findViewById(R.id.view_btn);
        bar_btn = findViewById(R.id.bar_btn);

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DataMenu.this, UserList.class));
            }
        });

    }
}