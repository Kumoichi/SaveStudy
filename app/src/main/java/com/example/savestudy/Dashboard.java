package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Dashboard extends AppCompatActivity {

    private LinearLayout todo_btn,timer_intent_btn, completed_intent_btn, graph_intent_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        todo_btn = findViewById(R.id.todo_btn);
        timer_intent_btn = findViewById(R.id.timer_intent_btn);
        completed_intent_btn = findViewById(R.id.completed_intent_btn);
        graph_intent_btn = findViewById(R.id.graph_intent_btn);

        //this is for moving to PlanPage.
        todo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,PlanPage.class);
                startActivity(intent);
            }
        });

        //this is for moving to Timer page.
        timer_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Timer.class);
                startActivity(intent);
            }
        });

        //this is for moving to UserList page.
        completed_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,BarGraph.class);
                startActivity(intent);
            }
        });

        //This is for moving to BarGraph page.
        graph_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,BarGraph.class);
                startActivity(intent);
            }
        });
    }
}