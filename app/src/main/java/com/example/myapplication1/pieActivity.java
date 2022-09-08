package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class pieActivity extends AppCompatActivity {
    private Button back;

    private ArrayList<Pie> pieArrayList = new ArrayList<>();
    private String[] arr = {"女", "男"};
//    private int[] pre = {20, 30, 10, 10, 10, 20};
    private int[] pre;
    private PieView pieView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        back=(Button)findViewById(R.id.back);
        pieView = (PieView) findViewById(R.id.PieView);

        Intent reintent = getIntent();
        String username = reintent.getStringExtra("user");

        DBService dbService = new DBService();
//        Toast.makeText(getApplicationContext(), "nihao", Toast.LENGTH_SHORT).show();
        List<ContentValues> res = dbService.query(pieActivity.this, "user", new String[] {"gender"}, null, null, null, null, null);

        int male, female;
        male = 0;
        female = 0;
//        Toast.makeText(getApplicationContext(), res.toString(), Toast.LENGTH_SHORT).show();
        for(ContentValues element: res){
            if(element.getAsInteger("gender") == 1){
//                Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                male++;
            }
            else if(element.getAsInteger("gender") == 0){
//                Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_SHORT).show();
                female++;
            }
        }
        Toast.makeText(getApplicationContext(), "male"+male+"", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "female"+female+"", Toast.LENGTH_SHORT).show();
        double num = male + female;
        Toast.makeText(getApplicationContext(), "num"+num+"", Toast.LENGTH_SHORT).show();

        double r_male = (double) (male/num);
        double r_female = (double) (female/num);
        Toast.makeText(getApplicationContext(), "rmale"+r_male+"", Toast.LENGTH_SHORT).show();
        int per_male =(int) Math.round (r_male * 100);
        int per_female = (int) Math.round (r_female * 100);
        Toast.makeText(getApplicationContext(), "permale"+per_male+"", Toast.LENGTH_SHORT).show();
        pre = new int[] {per_female, per_male};


//        int[] pieColor = {getResources().getColor(R.color.blue), getResources().getColor(R.color.red), getResources().getColor(R.color.gray_dark),
//                getResources().getColor(R.color.dark), getResources().getColor(R.color.red), getResources().getColor(R.color.black_alpha_light)};
        int[] pieColor = {getResources().getColor(R.color.red), getResources().getColor(R.color.blue)};
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
                t.putExtra("user", username);
                startActivity(t);
            }
        });
    }
}