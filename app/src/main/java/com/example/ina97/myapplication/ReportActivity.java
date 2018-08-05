package com.example.ina97.myapplication;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;

public class ReportActivity extends Activity {
    ListView listView;
    ListViewAdapter listViewAdapter;
    ArrayList <ReportItem> list;
    TextView title;
    Button bt_prev;
    Date date;

    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_report);

        title =findViewById(R.id.title);
        bt_prev=findViewById(R.id.Bnt_prev);

        final Intent intent=getIntent();
        String page_title = intent.getStringExtra("Page");
        final String name = intent.getStringExtra("Name");
        title.setText(page_title);

        list = new ArrayList<ReportItem>();
        listView = findViewById(R.id.report_list);

        //임시로
        list.add(new ReportItem(date, "ina", 1,0.0,0.0,0.0));
        listViewAdapter= new ListViewAdapter(getApplicationContext(),list);
        listView.setAdapter(listViewAdapter);

        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ReportActivity.this, MenuActivity.class);
                intent2.putExtra("Name", name);
                startActivity(intent2);
            }
        });

    }

    private class ListViewAdapter extends BaseAdapter{

        private List<ReportItem> list;
        private LayoutInflater inflater;

        private ListViewAdapter(Context context, ArrayList<ReportItem> list){
            this.list = list;
            inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;

            if(view==null){
                view =inflater.inflate(R.layout.report_item,viewGroup,false);
                holder = new ViewHolder();
                holder.tv_name= findViewById(R.id.item_name);
                holder.tv_date=findViewById(R.id.item_date);
                holder.tv_stool=findViewById(R.id.item_stool);
                holder.tv_urine=findViewById(R.id.item_urine);
                holder.tv_consume=findViewById(R.id.item_consume);
                view.setTag(holder);
            }
            else{
                holder=(ViewHolder)view.getTag();
            }

            holder.tv_name.setText(list.get(i).name);
            holder.tv_date.setText("today");
            holder.tv_stool.setText(valueOf(list.get(i).stool_cnt));
            holder.tv_urine.setText(valueOf(list.get(i).urine_amt));
            holder.tv_consume.setText(valueOf(list.get(i).consume_amt));

            return view;
        }
    }

    private class ViewHolder {
        TextView tv_name,tv_stool, tv_urine,tv_consume,tv_date;
    }
}
