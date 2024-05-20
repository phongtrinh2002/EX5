package com.phongth163965.ex5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EX5SQLiteHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "PMA";
    public static final String SQL_CREATE_PRODUCT = "CREATE TABLE \"Product\" (ID INTEGER PRIMARY KEY, Name TEXT, Price REAL, Image REAL)";
    public EX5SQLiteHelper(Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS Product;");
    }
}
