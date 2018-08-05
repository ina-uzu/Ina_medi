package com.example.ina97.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends Activity {
    TextView tv_stool, tv_urine, tv_consume,tv_report;
    Button bt_prev;
    String name,number;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Intent intent=getIntent();

        //Patient Info (name/number)
        name = intent.getStringExtra("Name");
        number= intent.getStringExtra("Number");

        tv_stool=findViewById(R.id.stool);
        tv_urine=findViewById(R.id.urine);
        tv_consume=findViewById(R.id.consume);
        tv_report =findViewById(R.id.report);
        bt_prev=findViewById(R.id.Bnt_prev);

        tv_stool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuActivity.this,TimeDateActivity.class);
                intent2.putExtra("Page", "stool");
                startActivity(intent2);
            }
        });

        tv_urine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuActivity.this,TimeDateActivity.class);
                intent2.putExtra("Page", "urine");
                startActivity(intent2);

            }
        });

        tv_consume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuActivity.this,TimeDateActivity.class);
                intent2.putExtra("Page", "consume");
                startActivity(intent2);

            }
        });

        tv_consume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuActivity.this,ReportActivity.class);
                intent2.putExtra("Page", "report");
                startActivity(intent2);

            }
        });

        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(intent2);

            }
        });

    }

}
