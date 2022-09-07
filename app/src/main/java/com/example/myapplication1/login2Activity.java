package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class login2Activity extends AppCompatActivity {
////定义一个类
//public class User {
//    private String UserName;
//    private String UserDetails;
//    private int photo;
//
//    public User() {
//    }
//
//    public User(String UserName, String UserDetails, int photo) {
//        this.UserName = UserName;
//        this.UserDetails = UserDetails;
//        this.photo = photo;
//    }
//
//    public String getName() {
//        return UserName;
//    }
//
//    public String getDetails() {
//        return UserDetails;
//    }
//
//    public int getPhoto() {
//        return photo;
//    }
//
//    public void setUserName(String UserName) {
//        this.UserName = UserName;
//    }
//
//    public void setUserDetails(String UserDetails) {
//        this.UserDetails = UserDetails;
//    }
//
//    public void setPhoto(int photo) {
//        this.photo = photo;
//    }
//}

//    private Button addFriends;
    private Button friends, me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
//        addFriends=(Button)findViewById(R.id.addFriend);

        Intent reintent = getIntent();
        String username = reintent.getStringExtra("user");

        ListView listview = (ListView)findViewById(R.id.list_view);
        String[] data={"a","b","c"};
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
}