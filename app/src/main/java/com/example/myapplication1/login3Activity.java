package com.example.myapplication1;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class login3Activity extends AppCompatActivity {

    private Button addFriends, friends, logout, piebt;
    ImageView imageView;
    TextView user;
    Spinner gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);


        Intent reintent = getIntent();
        String username = reintent.getStringExtra("user");
//        String savatar = reintent.getStringExtra("avatar");
//        int avatar = Integer.parseInt(savatar);

        addFriends = (Button) findViewById(R.id.addFriends);
        friends = (Button) findViewById(R.id.friends);
        piebt = (Button) findViewById(R.id.piebt);
        user = (TextView)findViewById(R.id.username);
        imageView=(ImageView)findViewById(R.id.imageView);
        gender = (Spinner)findViewById(R.id.gender);
        showAvatar(username);
        user.setText(username);

//        imageView.setImageResource(avatar);
//        user.setText(username);

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Logout successfully!", Toast.LENGTH_SHORT).show();
                Intent t = new Intent(login3Activity.this, MainActivity.class);
                startActivity(t);
                finish();
            }
        });
        addFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login3Activity.this, login2Activity.class);
                t.putExtra("user", username);
                startActivity(t);
            }
        });
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login3Activity.this, login1Activity.class);
                t.putExtra("user", username);
                startActivity(t);
            }
        });
        piebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login3Activity.this, pieActivity.class);
                t.putExtra("user", username);
                startActivity(t);
            }
        });

    }
    public void showAvatar(String username){
        DBService dbService = new DBService();
        List<ContentValues> res = dbService.query(login3Activity.this, "user", new String[] {"gender", "avatar"}, "u_id", new String[] {username}, null, null, null);
        ContentValues value = res.get(0);
        Toast.makeText(getApplicationContext(), value.getAsInteger("avatar").toString(), Toast.LENGTH_SHORT).show();
//        @DrawableRes int avatar = Integer.parseInt(value.getAsInteger("avatar").toString());
//        imageView.setImageResource(avatar);
        String temp = value.getAsInteger("avatar").toString();
        if(temp.equals("1")){
            imageView.setImageResource(R.drawable.avatar_1);
        }
        else if(temp.equals("2")){
            imageView.setImageResource(R.drawable.avatar_2);
        }
        else if(temp.equals("3")){
            imageView.setImageResource(R.drawable.avatar_3);
        }
        else if(temp.equals("4")){
            imageView.setImageResource(R.drawable.avatar_4);
        }
        else if(temp.equals("5")){
            imageView.setImageResource(R.drawable.avatar_5);
        }
        else if(temp.equals("6")){
            imageView.setImageResource(R.drawable.avatar_6);
        }
        else if(temp.equals("7")){
            imageView.setImageResource(R.drawable.avatar_7);
        }
        else if(temp.equals("8")){
            imageView.setImageResource(R.drawable.avatar_8);
        }
        else if(temp.equals("9")){
            imageView.setImageResource(R.drawable.avatar_9);
        }
        else if(temp.equals("10")){
            imageView.setImageResource(R.drawable.avatar_10);
        }
        else if(temp.equals("11")){
            imageView.setImageResource(R.drawable.avatar_11);
        }
        else if(temp.equals("12")){
            imageView.setImageResource(R.drawable.avatar_12);
        }
        else if(temp.equals("13")){
            imageView.setImageResource(R.drawable.avatar_13);
        }
        gender.setSelection(value.getAsInteger("gender"));
    }

}