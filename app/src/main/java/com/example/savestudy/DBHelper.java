package com.example.savestudy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "Userdata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table Userdetails(subject Text , toDoTask TEXT , stuTime TEXT, count INTEGER primary key) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists Userdetails");

    }

    public Boolean insertuserData(String subject, String toDoTask, String stuTime, int count) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject", subject);
        contentValues.put("toDoTask", toDoTask);
        contentValues.put("stuTime", stuTime);
        contentValues.put("count", count);
        long result = db.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String getSum()
    {
        //initialize database
        SQLiteDatabase database = getReadableDatabase();

        //initialize string
        String sAmount;
        //Query for getting sum
        String sQuery = "select sum(stuTime) from " + "Userdetails";

        Cursor cursor = database.rawQuery(sQuery,null);

        //check condition
        if(cursor.moveToFirst())
        {
            //when cursor moves to first item
            //get total amount
            sAmount = String.valueOf(cursor.getInt(0));
        }
        else{
            sAmount = "0";
        }
        cursor.close();
        database.close();
        //pass total
        return sAmount;
    }

    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Userdetails", null);
        return cursor;
    }
}
