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
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    EditText subject;
    TextView toDoTask, stuTime, total_text;
    Button insert_btn, view_btn, total_btn;
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
        total_text = findViewById(R.id.total_text);

        db = new DBHelper(this);

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UserList.class));
            }
        });

        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject_text = subject.getText().toString();
                String task_text = toDoTask.getText().toString();
                String stuTime_text = stuTime.getText().toString();

                Random rand = new Random();
                int count = rand.nextInt(10000000);

                Boolean checkinsertData = db.insertuserData(subject_text,task_text,stuTime_text,count);
                if(checkinsertData==true){
                    Toast.makeText(MainActivity.this, "New data inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        total_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total_text.setText(db.getSum());

            }
        });
    }
}