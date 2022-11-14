package com.example.savestudy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String ALERT_DATABASE = "Userdata.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Userdetails";
    private static final String SUBJECT_ID = "subject";
    private static final String TODO_ID = "toDoTask";
    private static final String TIME_ID = "stuTime";
    private static final String COUNT_ID = "count";

    private static final String TABLE_NAME2 = "barchart_table";
    private static final String KEY_ID = "id";
    private static final String DATE = "date";
    private static final String yAXIS = "yaxis";


    private static final String CREATE_ALERT_TYPE="CREATE TABLE "
            + TABLE_NAME + " ( "
            + SUBJECT_ID +" TEXT,"
            + TODO_ID +" TEXT,"
            + TIME_ID +" TEXT,"
            + COUNT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT)";

    private static final String CREATE_ALERT_INFORMATION="CREATE TABLE "
            + TABLE_NAME2 + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DATE + " TEXT,"
            + yAXIS + " TEXT)";


    public DBHelper(@Nullable Context context) {
        super(context, ALERT_DATABASE,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ALERT_TYPE);
        sqLiteDatabase.execSQL(CREATE_ALERT_INFORMATION);
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
        long result = db.insert(TABLE_NAME, null, contentValues);
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


    //for the Graph view
}
