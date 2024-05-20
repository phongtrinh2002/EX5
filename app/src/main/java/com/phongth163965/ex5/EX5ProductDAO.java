package com.phongth163965.ex5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EX5ProductDAO {
    private EX5SQLiteHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;

    public EX5ProductDAO(Context context){
        this.context = context;
        dbHelper = new EX5SQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertProduct(Product p){
        ContentValues values = new ContentValues();
        values.put("ID", p.getId());
        values.put("Name", p.getName());
        values.put("Price", p.getPrice());

        if(db.insert("Product", null , values) < 0){
            return -1;
        }
        return 1;
    }

    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();

        Cursor c = db.query("Product", null, null, null ,null ,null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Product product = new Product();
            product.setId(c.getString(0));
            product.setName(c.getString(1));
            product.setPrice(c.getDouble(2));
            list.add(product);
            c.moveToNext();
        }
        c.close();
        return list;
    }
}
