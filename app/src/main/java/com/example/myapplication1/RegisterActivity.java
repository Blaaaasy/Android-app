package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private Button register, back;
    private EditText user,pwd,rpw;
    private RadioButton ButtonM,ButtonW;
    DBService DBService =new DBService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        register = (Button) findViewById(R.id.register);
        back = (Button) findViewById(R.id.back);
        user = (EditText) super.findViewById(R.id.user);
        pwd = (EditText) super.findViewById(R.id.pwd);
        rpw = (EditText) super.findViewById(R.id.rpw);
        ButtonM = (RadioButton) super.findViewById(R.id.ButtonM);
        ButtonW = (RadioButton) super.findViewById(R.id.ButtonW);

        register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(user.getText().toString().length()<6 || pwd.getText().toString().length()<6){
                    Toast.makeText(getApplicationContext(), "用户名或密码长度需大于6位", Toast.LENGTH_SHORT).show();
                }
                else if(is_exist(user.getText().toString())){
                    Toast.makeText(getApplicationContext(), "用户名已存在", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pwd.getText().toString().equals(rpw.getText().toString())){
                        ContentValues value = new ContentValues();
                        value.put("u_id", user.getText().toString());
                        value.put("psd", pwd.getText().toString());
                        int gender = 0;
                        if(ButtonM.isChecked()){
                            gender = 1;
                        }
                        else if(ButtonW.isChecked()){
                            gender = 0;
                        }
                        value.put("gender", gender);
                        DBService.insert(RegisterActivity.this, "user", value);
                        Toast.makeText(getApplicationContext(), "Register successfully!", Toast.LENGTH_SHORT).show();
                        Intent t = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(t);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "两次密码不同", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent t = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(t);
                finish();
            }
        });
    }

    public boolean is_exist(String username){
        DBService dbService = new DBService();
        List<ContentValues> res = dbService.query(RegisterActivity.this, "user", new String[] {"u_id"}, "u_id", new String[] {username}, null, null, null);

        ContentValues value = res.get(0);
        if(value.get("u_id").toString().equals(username)){
            return true;
        }
        else {
            return false;
        }
    }
}