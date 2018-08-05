package com.example.ina97.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StoolActivity extends Activity {

    Button bt_prev, bt_next;
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_stool);

        bt_next=findViewById(R.id.Bnt_next);
        bt_prev=findViewById(R.id.Bnt_prev);

        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(StoolActivity.this,TimeDateActivity.class);
                startActivity(intent2);

            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(StoolActivity.this,MenuActivity.class);
                startActivity(intent2);

            }
        });

    }
}
