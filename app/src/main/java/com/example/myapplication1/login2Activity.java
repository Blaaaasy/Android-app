package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class login2Activity extends AppCompatActivity {
    private Button friends, me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Intent reintent = getIntent();
        String username = reintent.getStringExtra("user");

        ListView listview = (ListView)findViewById(R.id.list_view);
//        List<String> tmp = new ArrayList<>();
//        List<ContentValues> friendList=getFriends(username);
//        for(ContentValues element: friendList){
//
//        }
        String[] data={};
        UserAdapter adapter = new UserAdapter(this, R.layout.user2, data);
        listview.setAdapter(adapter);

        friends = (Button) findViewById(R.id.friends);
        me = (Button) findViewById(R.id.me);


        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login2Activity.this, login1Activity.class);
                t.putExtra("user", username);
                startActivity(t);
            }
        });
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login2Activity.this, login3Activity.class);
                t.putExtra("user", username);
                startActivity(t);
            }
        });
    }
    public List<ContentValues> getFriends(String username){
        DBService dbService = new DBService();
        List<ContentValues> res = dbService.query(login2Activity.this, "user", new String[] {"u_id", "avatar"}, null, null, null, null, null);

//        for(ContentValues element: res){
//
//        }
//        ContentValues value = res.get(0);

        return res;
    }
}