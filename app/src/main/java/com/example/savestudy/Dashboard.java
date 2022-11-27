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

        todo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,PlanPage.class);
                startActivity(intent);
            }
        });

        timer_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Timer.class);
                startActivity(intent);
            }
        });


        completed_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,UserList.class);
                startActivity(intent);
            }
        });

        graph_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,BarGraph.class);
                startActivity(intent);
            }
        });
    }
}