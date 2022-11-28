package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DataMenu extends AppCompatActivity {

    ImageButton completed_btn, graph_btn;
    Button view_btn, bar_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_menu);

        view_btn = findViewById(R.id.view_btn);

        completed_btn = findViewById(R.id.completed_btn);
        graph_btn = findViewById(R.id.graph_btn);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("timedata", 0);


        completed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataMenu.this, UserList.class);
                startActivity(intent);
            }
        });

        graph_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studyTime = String.valueOf(intValue);
                Intent intent = new Intent(DataMenu.this, BarGraph.class);
                intent.putExtra("key", studyTime);
                startActivity(intent);
            }
        });



        /*
        this is for when you want to put total time on the top of graph view.
        total_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String totalVal = db.getSum();
                Intent i = new Intent(MainActivity.this, BarGraph.class);
                i.putExtra("key",totalVal);
                startActivity(i);
            }
        });
*/

    }
}