package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button login, register;
    EditText username;
    EditText password;
    ImageView avatar;
    TextView change;
    int current_avatar = 1;

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
//        check_avatar();

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
                if(login(username.getText().toString(), password.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    Intent t = new Intent(MainActivity.this, login1Activity.class);
                    t.putExtra("user", username.getText().toString());
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


        register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent t = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(t);
            }
        });
    }
    public boolean login(String username, String pwd){
        DBService dbService = new DBService();
        List<ContentValues> res = dbService.query(MainActivity.this, "user", new String[] {"psd"}, "u_id", new String[] {username}, null, null, null);

        ContentValues value = res.get(0);
        if(value.get("psd").toString().equals(pwd)){
            set_avatar(dbService, username);
            return true;
        }
        else {
            return false;
        }
    }
    public void set_avatar(DBService dbService, String username){
        List<ContentValues> res = dbService.query(MainActivity.this, "user", new String[] {"avatar"}, "u_id", new String[] {username}, null, null, null);
        ContentValues value = res.get(0);
        value.put("avatar", current_avatar);
        dbService.update(MainActivity.this, "user", username, value);
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
            current_avatar = temp;
        }
        else if(temp == 2){
            avatar.setImageResource(R.drawable.avatar_2);
            current_avatar = temp;
        }
        else if(temp == 3){
            avatar.setImageResource(R.drawable.avatar_3);
            current_avatar = temp;
        }
        else if(temp == 4){
            avatar.setImageResource(R.drawable.avatar_4);
            current_avatar = temp;
        }
        else if(temp == 5){
            avatar.setImageResource(R.drawable.avatar_5);
            current_avatar = temp;
        }
        else if(temp == 6){
            avatar.setImageResource(R.drawable.avatar_6);
            current_avatar = temp;
        }
        else if(temp == 7){
            avatar.setImageResource(R.drawable.avatar_7);
            current_avatar = temp;
        }
        else if(temp == 8){
            avatar.setImageResource(R.drawable.avatar_8);
            current_avatar = temp;
        }
        else if(temp == 9){
            avatar.setImageResource(R.drawable.avatar_9);
            current_avatar = temp;
        }
        else if(temp == 10){
            avatar.setImageResource(R.drawable.avatar_10);
            current_avatar = temp;
        }
        else if(temp == 11){
            avatar.setImageResource(R.drawable.avatar_11);
            current_avatar = temp;
        }
        else if(temp == 12){
            avatar.setImageResource(R.drawable.avatar_12);
            current_avatar = temp;
        }
        else if(temp == 13){
            avatar.setImageResource(R.drawable.avatar_13);
            current_avatar = temp;
        }
    }
}