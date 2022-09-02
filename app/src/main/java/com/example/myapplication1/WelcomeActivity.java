package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    private Button logout;
    TextView show_welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent reintent = getIntent();
        String tempstr = reintent.getStringExtra("key");
        show_welcome = (TextView) findViewById(R.id.welcome);
        show_welcome.setText("Welcome!\n"+tempstr);
        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Logout successfully!", Toast.LENGTH_SHORT).show();
                Intent t = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(t);
            }
        });
    }
}