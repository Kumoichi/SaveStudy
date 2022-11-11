package com.example.savestudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> subject, toDoTask, stuTime;
    DBHelper db;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        db=new DBHelper(this);
        subject = new ArrayList<>();
        toDoTask = new ArrayList<>();
        stuTime = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new Adapter(this,subject,toDoTask,stuTime);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData()
    {
        Cursor cursor = db.getData();
        if(cursor.getCount()==0){
            Toast.makeText(this,"no data exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                subject.add(cursor.getString(0));
                toDoTask.add(cursor.getString(1));
                stuTime.add(cursor.getString(2));
            }
        }
    }
}