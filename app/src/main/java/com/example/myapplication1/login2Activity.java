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

private Button addFriends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        addFriends=(Button)findViewById(R.id.addFriend);
// 获取界面组件
        ListView listView = (ListView) findViewById(R.id.list_view);

        // 定义要显示的数组
        String[] contents = {"Android", "demo", "Edit", "APP", "excel",
                "dota", "Button", "Circle", "excel", "back"};

        // 将数组包装为自定义MyArrayAdapter
        UserAdapter adapter = new UserAdapter(this, R.layout.activity_login2, contents);

        // 为ListView设置Adapter
        listView.setAdapter(adapter);

        addFriends.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }


}