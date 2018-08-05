package com.example.ina97.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimeDateActivity extends Activity {
    Button bt_prev, bt_next, bt_time,bt_date;
    TextView title;
    final int DIALOG_DATE = 1;
    final int DIALOG_TIME = 2;

    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_tima_date);

        title=findViewById(R.id.title);
        bt_next=findViewById(R.id.Bnt_next);
        bt_prev=findViewById(R.id.Bnt_prev);
        bt_date=findViewById(R.id.bt_date);
        bt_time=findViewById(R.id.bt_time);

        //title 표시
        Intent intent = getIntent();
        String page_title= intent.getStringExtra("Page");
        title.setText(page_title);

        //Date
        bt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_DATE);
            }
        });

        //Time
        bt_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_TIME);
            }
        });

        //prev(Menu page)
        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(TimeDateActivity.this,MenuActivity.class);
                startActivity(intent2);

            }
        });

        //Next
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(TimeDateActivity.this, StoolActivity.class);
                Toast.makeText(getApplicationContext(),"Hello", Toast.LENGTH_LONG).show();
                startActivity(intent2);

            }
        });

    }

    public Dialog onCreateDialog(int id){
        switch(id){
            case DIALOG_DATE :
                DatePickerDialog datePickerDialog = new DatePickerDialog(TimeDateActivity.this,
                        new DatePickerDialog.OnDateSetListener(){
                    public void onDateSet(DatePicker view, int year, int month, int day){
                        Toast.makeText(getApplicationContext(),year+"년 "+(month+1)+"월 "+day +"일을 선택했습니다",Toast.LENGTH_LONG).show();
                    }
                        },2018,8,5);
                return datePickerDialog;

            case DIALOG_TIME :
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimeDateActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                                Toast.makeText(getApplicationContext(),hour+"시 "+ minute +"분을 선택했습니다",Toast.LENGTH_LONG).show();
                            }
                        }, 12,30,false);
                return timePickerDialog;
        }
        return super.onCreateDialog(id);
    }

}
