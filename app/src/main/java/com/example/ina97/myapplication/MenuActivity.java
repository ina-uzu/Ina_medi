package com.example.ina97.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends Activity {
    TextView tv_stool, tv_urine, tv_consume;
    String name;
    Integer number;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Intent intent=getIntent();

        //Patient Info (name/number)
        name = intent.getStringExtra("Name");
        intent.getIntExtra("Number", number);

        tv_stool=findViewById(R.id.stool);
        tv_urine=findViewById(R.id.urine);
        tv_consume=findViewById(R.id.consume);

        tv_stool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuActivity.this,StoolActivity.class);
                startActivity(intent2);
            }
        });

        tv_urine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuActivity.this,StoolActivity.class);
                startActivity(intent2);

            }
        });

        tv_consume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuActivity.this,StoolActivity.class);
                startActivity(intent2);

            }
        });


    }

}
