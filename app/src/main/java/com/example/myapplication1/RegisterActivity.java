package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button register, back;
    private EditText user,pwo;
    private RadioButton ButtonM,ButtonW;
    DBService DBService =new DBService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        register = (Button) findViewById(R.id.register);
        back = (Button) findViewById(R.id.back);
        user = (EditText) super.findViewById(R.id.user);
        pwo = (EditText) super.findViewById(R.id.pwo);
        ButtonM = (RadioButton) super.findViewById(R.id.ButtonM);
        ButtonW = (RadioButton) super.findViewById(R.id.ButtonW);

        register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                DBService.insert(user.getText().toString(),pwo.getText().toString(), ButtonM.getText().toString(),ButtonW.getText().toString(),null);
                Toast.makeText(getApplicationContext(), "Register successfully!", Toast.LENGTH_SHORT).show();
                Intent t = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(t);
                finish();
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
}