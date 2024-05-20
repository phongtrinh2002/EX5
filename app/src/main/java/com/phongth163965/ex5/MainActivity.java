package com.phongth163965.ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EX5BaseAdapter adapter;
    List<Product> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ex5_lv);
        EX5ProductDAO dao = new EX5ProductDAO(this);
        //Product p = new Product("2", "Dac Nhan Tam", 1.0, 2);
        //int kq = dao.insertProduct(p);
        list = dao.getAll();
        adapter = new EX5BaseAdapter(list, this);
        listView.setAdapter(adapter);
    }
}