package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.myapplication1.UserAdapter;

public class login1Activity extends AppCompatActivity {

    private Button addFriends, me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        Intent reintent = getIntent();
        String username = reintent.getStringExtra("user");

        ListView listview = (ListView)findViewById(R.id.list_view);
        String[] data={"a","b","c"};
        UserAdapter adapter = new UserAdapter(this, R.layout.user, data);
        listview.setAdapter(adapter);

        addFriends = (Button) findViewById(R.id.addFriends);
        me = (Button) findViewById(R.id.me);


        addFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login1Activity.this, login2Activity.class);
                t.putExtra("user", username);
                startActivity(t);
            }
        });
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login1Activity.this, login3Activity.class);
                t.putExtra("user", username);
                startActivity(t);
            }
        });
    }
}