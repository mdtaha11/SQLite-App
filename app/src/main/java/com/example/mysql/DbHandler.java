package com.example.mysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {


    private static String DATABASE_NAME="country.db";
    private static int DATABASE_VERSION=1;
    private static String TABLE_NAME="Country";
    private static String COLOUMN_1="id";
    private static String COLOUMN_2="Countries";
    private static String COLOUMN_3="Capitals";


    public DbHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(" CREATE TABLE " + TABLE_NAME + " ( " + COLOUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_2 + " TEXT, " + COLOUMN_3 + " TEXT " + " ); " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

     public boolean inputData(String country, String capital)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLOUMN_2,capital);
        cv.put(COLOUMN_3,country);
        long result=db.insert(TABLE_NAME,null,cv);
        if (result==-1)
            return false;
        else
            return true;

    }
}
