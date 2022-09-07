package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class pieActivity extends AppCompatActivity {
    private Button back;

    private ArrayList<Pie> pieArrayList = new ArrayList<>();
    private String[] arr = {"C#", "C", "C++", "JAVA", "JavaScript", "Object-C"};
    private int[] pre = {20, 30, 10, 10, 10, 20};
    private PieView pieView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        back=(Button)findViewById(R.id.back);
        pieView = (PieView) findViewById(R.id.PieView);

        int[] pieColor = {getResources().getColor(R.color.blue), getResources().getColor(R.color.red), getResources().getColor(R.color.gray_dark),
                getResources().getColor(R.color.dark), getResources().getColor(R.color.red), getResources().getColor(R.color.black_alpha_light)};
        for (int i = 0; i < arr.length; i++) {
            Pie pie = new Pie(pre[i], arr[i], pieColor[i]);
            pieArrayList.add(pie);
        }
        pieView.SetPie(pieArrayList);


        back.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent t = new Intent(pieActivity.this, login3Activity.class);
                startActivity(t);
            }
        });
    }
}