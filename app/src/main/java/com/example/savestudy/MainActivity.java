package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText subject;
    TextView toDoTask, stuTime;
    Button insert_btn, view_btn, total_btn, goTimer_btn,bar_btn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subject = findViewById(R.id.subject_ed);
        toDoTask = findViewById(R.id.toDoTask);
        stuTime = findViewById(R.id.timeData);
        insert_btn = findViewById(R.id.insert_btn);
        view_btn = findViewById(R.id.view_btn);
        total_btn = findViewById(R.id.total_btn);
        goTimer_btn = findViewById(R.id.goTimer_btn);
        bar_btn = findViewById(R.id.bar_btn);

        db = new DBHelper(this);

        //getting timer value
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("timedata", 0);
        String studyTime = String.valueOf(intValue);
       stuTime.setText(studyTime);

       /*
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UserList.class));
            }
        });
        */


        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject_text = subject.getText().toString();
                String task_text = toDoTask.getText().toString();
                String stuTime_text = stuTime.getText().toString();

                //getting cursor object
                Cursor cursor = db.getCount();
                String ordering = null;
                //this code is for top to bottom recyclerview
                int order = 100000;

                if(cursor.moveToNext()) {
                    {
                        //getting the first value of count in database to get lowest value.
                        cursor.moveToFirst();
                        ordering = String.valueOf(cursor.getInt(0));
                    }
                    order = Integer.parseInt(ordering);
                    order = order -1;
                    subject.setText(String.valueOf(order));
                }


                Boolean checkinsertData = db.insertuserData(subject_text,task_text,stuTime_text,order);
                if(checkinsertData==true){
                    Toast.makeText(MainActivity.this, "New data inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"not inserted", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(MainActivity.this, DataMenu.class);
                intent.putExtra("timedata", intValue);
                startActivity(intent);
            }
        });

        /*bar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String studyTime = String.valueOf(intValue);
                Intent intent = new Intent(MainActivity.this, BarGraph.class);
                intent.putExtra("key", studyTime);
                startActivity(intent);
            }
        });*/

        goTimer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Dashboard.class));
            }
        });
    }
}