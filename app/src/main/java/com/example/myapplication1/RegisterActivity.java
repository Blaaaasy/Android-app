package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button register, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        register = (Button) findViewById(R.id.register);
        back = (Button) findViewById(R.id.back);
        register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
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