package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class login3Activity extends AppCompatActivity {

    private Button addFriends, friends;
    ImageView imageView;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);


        Intent reintent = getIntent();
        String username = reintent.getStringExtra("user");
        String savatar = reintent.getStringExtra("avatar");
        int avatar = Integer.parseInt(savatar);

        addFriends = (Button) findViewById(R.id.addFriends);
        friends = (Button) findViewById(R.id.friends);
        user = (TextView)findViewById(R.id.username);
        imageView=(ImageView)findViewById(R.id.imageView);

        imageView.setImageResource(avatar);
        user.setText(username);

        addFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login3Activity.this, login2Activity.class);
                startActivity(t);
            }
        });
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login3Activity.this, login1Activity.class);
                startActivity(t);
            }
        });

    }
}