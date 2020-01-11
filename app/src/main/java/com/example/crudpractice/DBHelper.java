package com.example.crudpractice;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DATABASE_NAME = "Reddy";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary table you want to create
        String CREATE_TABLE = "CREATE TABLE " + Constants.TABLE + "("
                + Constants.COL_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Constants.COL_NAME + " VARCHAR(255),"
                + Constants.COL_EMAIL + " VARCHAR(255),"
                + Constants.COL_CNAME + " VARCHAR(255));";
        //Execute query to create table
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Constants.TABLE);
        onCreate(db);
    }
}
