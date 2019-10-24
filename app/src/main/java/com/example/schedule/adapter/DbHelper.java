package com.example.schedule.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class  DbHelper extends SQLiteOpenHelper {


        public static int dbversion =1;
        public static String dbName = "schedule";
        public static String dbTable = "content";


        public DbHelper(Context context)
        {
            super(context, dbName,null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("create table "+dbTable+"( id integer primary key autoincrement, title, description, day )");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("drop table if exists "+dbTable);
            onCreate(db);

        }

        public void insert(String title, String desc,String day)
        {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", title);
            contentValues.put("description", desc);
            contentValues.put("day", day);
            this.getWritableDatabase().insertOrThrow(dbTable, "", contentValues);
        }


    public Cursor fetchAllData(String day)
    {

        String subquery ="select * from "+ dbTable+" where day = '"+ day+"'";
        String query="select * from "+ dbTable;

        Cursor row =this.getReadableDatabase().rawQuery(subquery,null);

        return row;
    }
    }
