package com.example.ina97.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TimeDateActivity extends Activity {
    Button bt_prev, bt_next;
    TextView title;
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_tima_date);

        //title 얻어오기
        Intent intent = getIntent();
        String page_title= intent.getStringExtra("Page");

        title=findViewById(R.id.title);
        bt_next=findViewById(R.id.Bnt_next);
        bt_prev=findViewById(R.id.Bnt_prev);

        title.setText(page_title);

        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(TimeDateActivity.this,MenuActivity.class);
                startActivity(intent2);

            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(TimeDateActivity.this, StoolActivity.class);
                Toast.makeText(getApplicationContext(),"Hello", Toast.LENGTH_LONG).show();
                //startActivity(intent2);

            }
        });

    }

}
