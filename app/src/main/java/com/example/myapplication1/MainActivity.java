package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login, register;
    EditText username;
    EditText password;
    ImageView avatar;
    TextView change;
    int current_avatar = R.drawable.avatar_1;

    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        username=(EditText)super.findViewById(R.id.username);//获取用户输入的用户名
        password=(EditText)super.findViewById(R.id.password);//获取用户密码
        avatar=(ImageView)findViewById(R.id.avatar);
        change=(TextView)findViewById(R.id.change);

        login.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                showProgress();
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
                    Intent t = new Intent(MainActivity.this, login1Activity.class);
                    t.putExtra("user", username.getText().toString());
                    t.putExtra("avatar", current_avatar+"");
                    startActivity(t);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Fail!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAvatar();
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAvatar();
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
    public void showProgress() {
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
    public void changeAvatar() {
        int temp = (int) (Math.random()*13+1);
        if(temp == 1){
            avatar.setImageResource(R.drawable.avatar_1);
            current_avatar = R.drawable.avatar_1;
        }
        else if(temp == 2){
            avatar.setImageResource(R.drawable.avatar_2);
            current_avatar = R.drawable.avatar_2;
        }
        else if(temp == 3){
            avatar.setImageResource(R.drawable.avatar_3);
            current_avatar = R.drawable.avatar_3;
        }
        else if(temp == 4){
            avatar.setImageResource(R.drawable.avatar_4);
            current_avatar = R.drawable.avatar_4;
        }
        else if(temp == 5){
            avatar.setImageResource(R.drawable.avatar_5);
            current_avatar = R.drawable.avatar_5;
        }
        else if(temp == 6){
            avatar.setImageResource(R.drawable.avatar_6);
            current_avatar = R.drawable.avatar_6;
        }
        else if(temp == 7){
            avatar.setImageResource(R.drawable.avatar_7);
            current_avatar = R.drawable.avatar_7;
        }
        else if(temp == 8){
            avatar.setImageResource(R.drawable.avatar_8);
            current_avatar = R.drawable.avatar_8;
        }
        else if(temp == 9){
            avatar.setImageResource(R.drawable.avatar_9);
            current_avatar = R.drawable.avatar_9;
        }
        else if(temp == 10){
            avatar.setImageResource(R.drawable.avatar_10);
            current_avatar = R.drawable.avatar_10;
        }
        else if(temp == 11){
            avatar.setImageResource(R.drawable.avatar_11);
            current_avatar = R.drawable.avatar_11;
        }
        else if(temp == 12){
            avatar.setImageResource(R.drawable.avatar_12);
            current_avatar = R.drawable.avatar_12;
        }
        else if(temp == 13){
            avatar.setImageResource(R.drawable.avatar_13);
            current_avatar = R.drawable.avatar_13;
        }
    }
}