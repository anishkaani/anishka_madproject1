package com.example.anishkaproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "SimpleData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE UserData(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS UserData");
        onCreate(db);
    }

    public boolean insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        long result = db.insert("UserData", null, contentValues);
        return result != -1; // return true if data is inserted successfully
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        // Query to select all rows from the UserData table
        return db.rawQuery("SELECT * FROM UserData", null);
    }
}
