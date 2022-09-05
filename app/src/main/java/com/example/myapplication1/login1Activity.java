package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class login1Activity extends AppCompatActivity {

    private String[] data={"a","b","c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(login1Activity.this, android.R.layout.simple_list_item_1,data);
        ListView listview = (ListView)findViewById(R.id.list_view);
        listview.setAdapter(adapter);
    }
}