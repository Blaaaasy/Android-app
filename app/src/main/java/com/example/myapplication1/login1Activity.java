package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import com.example.myapplication1.UserAdapter;

public class login1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        ListView listview = (ListView)findViewById(R.id.list_view);
        String[] data={"a","b","c"};
        UserAdapter adapter = new UserAdapter(this, R.layout.user, data);
        listview.setAdapter(adapter);
    }
}