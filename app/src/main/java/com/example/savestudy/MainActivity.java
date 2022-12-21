package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView stuTime,textView_subject,textView_task;
    ImageButton insert_btn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stuTime = findViewById(R.id.timeData);
        insert_btn = findViewById(R.id.insert_btn);
        textView_subject = findViewById(R.id.textView_subject);
        textView_task = findViewById(R.id.textView_task);

        db = new DBHelper(this);
        //getting timer value
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("timedata", 0);
        String getSubject = mIntent.getStringExtra("subject_two");
        String getTask = mIntent.getStringExtra("task_two");
        int hours = intValue / 3600;
        int minutes = (intValue % 3600) / 60;
        int seconds = intValue % 60;

        String hoursString = String.valueOf(hours);
        String minutesString = String.valueOf(minutes);
        String secondsString = String.valueOf(seconds);

        String studyTime = (hoursString + ":" + minutesString + ":" + secondsString);
        stuTime.setText(studyTime);
        textView_subject.setText(getSubject);
        textView_task.setText(getTask);


        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ここにテキストを入れるようにすればいいだけだからエディットも消せるはず
                String subject_text = textView_subject.getText().toString();
                String task_text = textView_task.getText().toString();
                //String task_text = toDoTask.getText().toString();
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

    }
}