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

    EditText subject, toDoTask;
    TextView stuTime;
    ImageButton insert_btn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subject = findViewById(R.id.subject_ed);
        //toDoTask = findViewById(R.id.toDoTask);
        stuTime = findViewById(R.id.timeData);
        insert_btn = findViewById(R.id.insert_btn);

        db = new DBHelper(this);
        //getting timer value
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("timedata", 0);
        String studyTime = String.valueOf(intValue);
       stuTime.setText(studyTime);

        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ここにテキストを入れるようにすればいいだけだからエディットも消せるはず
                String subject_text = subject.getText().toString();
                String task_text = "hi";
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