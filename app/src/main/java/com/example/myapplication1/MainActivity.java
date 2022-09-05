package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login, register;
    EditText username;
    EditText password;

    ProgressDialog pd;
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
                new Thread(){
                    public void run(){
                        for (int i=0; i<=100; i++){
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            Message msg = Message.obtain();
                            msg.arg1 = i;
                            msg.what = 1;
                            handler.sendMessage(msg);
                        }
                        handler.sendEmptyMessage(0);
                    }
                }.start();
                if(username.getText().toString().equals("admin")&&password.getText().toString().equals("123456"))
                {
                    Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();
                    Intent t = new Intent(MainActivity.this, login1Activity.class);//从login页面跳转到index界面
                    t.putExtra("key", username.getText().toString());
                    startActivity(t);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Fail!", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        ListView listView = (ListView) findViewById(R.id.list_view);
//
//        // 定义要显示的数组
//        String[] contents = {"Android", "demo", "Edit", "APP", "excel",
//                "dota", "Button", "Circle", "excel", "back"};
//
//        // 将数组包装为自定义MyArrayAdapter
//        UserAdapter adapter = new UserAdapter(this, R.layout.user, contents);
//
//        // 为ListView设置Adapter
//        listView.setAdapter(adapter);


        register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent t = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(t);
            }
        });
    }
    public void showprogress() {
        pd=new ProgressDialog(this);
        pd.setTitle( "登陆中" );
        pd.setMessage( "请稍后..." );
        pd.setCancelable( true );
        pd.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL);//风格
        pd.setMax(100);
        pd.show();
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what==0){
                pd.dismiss();
            }
            else if(msg.what==1){
                pd.setProgress(msg.arg1);
            }
        }
    };
}