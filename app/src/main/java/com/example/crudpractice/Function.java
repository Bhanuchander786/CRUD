package com.example.crudpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Function {
    String name, email, cname;

    public DBHelper dbHelper;

    //constructor to create the Object Instantly
    Function(Context context) {

        dbHelper = new DBHelper(context);
    }

    public long insertData(String name, String email, String cname) {
        this.name = name;
        this.email = email;
        this.cname = cname;

        //Open the connection to write the data
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.COL_NAME, name);
        contentValues.put(Constants.COL_EMAIL, email);
        contentValues.put(Constants.COL_CNAME, cname);
        //insert into table using built in method insert in SQLDatabase.class

        long retid = sqLiteDatabase.insert(Constants.TABLE, null, contentValues);
        return retid;
    }

    public String viewData() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] coloums = {Constants.COL_ID, Constants.COL_NAME, Constants.COL_EMAIL, Constants.COL_CNAME};
        Cursor cursor = db.query(Constants.TABLE, coloums, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int cid = cursor.getInt(cursor.getColumnIndex(Constants.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(Constants.COL_NAME));
            String email = cursor.getString(cursor.getColumnIndex(Constants.COL_EMAIL));
            String cname = cursor.getString(cursor.getColumnIndex(Constants.COL_CNAME));
            buffer.append(cid + "" + name + "" + email + "" + cname);
        }
        return buffer.toString();
    }


    public  long edit(String id,String name){
        //open connection to write the data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COL_ID,name);

        String [] whereArgs = {id};
        long retid = db.update(Constants.TABLE,values,Constants.COL_ID+"=?",whereArgs);
        return  retid;

    }

    public  int delete(String id)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] whereArgs ={id};
        int retid = db.delete(Constants.TABLE,Constants.COL_ID+"=?",whereArgs);
        return retid;
    }

}
