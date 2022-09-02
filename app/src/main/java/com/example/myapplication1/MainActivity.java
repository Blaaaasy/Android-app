package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login, register;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        username=(EditText)super.findViewById(R.id.username);//获取用户输入的用户名
        password=(EditText)super.findViewById(R.id.password);//获取用户密码
        login.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                showprogress();
                if(username.getText().toString().equals("admin")&&password.getText().toString().equals("123456"))
                {
                    Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();
                    Intent t = new Intent(MainActivity.this, WelcomeActivity.class);//从login页面跳转到index界面
                    t.putExtra("key", username.getText().toString());
                    startActivity(t);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Fail!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent t = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(t);
            }
        });
    }
    ProgressDialog pd;
    public void showprogress() {
        pd=new ProgressDialog(this);
        pd.setTitle( "登陆中" );
        pd.setMessage( "请稍后..." );
        pd.setCancelable( true );
        pd.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL);//风格
        pd.setMax(100);
        int i;
        for (i=0;i<100;i++){
            pd.setProgress(i);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
            }
        }
        pd.show();
    }
}