package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class PlanPage extends AppCompatActivity {

    private EditText task_edit, subject_edit;
    private ImageView timeview_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_page);
        task_edit = findViewById(R.id.task_edit);
        subject_edit = findViewById(R.id.subject_edit);
        timeview_button = findViewById(R.id.timerview_button);


        timeview_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanPage.this, Timer.class);

                String task_one = task_edit.getText().toString();
                String tasks = task_one;
                intent.putExtra("task_one", tasks);

                String subject_one = subject_edit.getText().toString();
                String subjects = subject_one;
                intent.putExtra("subject_one", subjects);

                startActivity(intent);
            }
        });
    }
}