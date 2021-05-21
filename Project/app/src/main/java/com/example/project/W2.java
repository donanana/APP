package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class W2 extends AppCompatActivity implements DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener,
        View.OnClickListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    DatePicker dd;
    TextView t1,t2;
    Time t;
    int y,m,d;
    TimePicker tt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w2);
        dd=(DatePicker)findViewById(R.id.dp);
        tt=(TimePicker) findViewById(R.id.tp);
        t1=(TextView)findViewById(R.id.tv1);
        t2=(TextView)findViewById(R.id.tv2);
        t=new Time("GMT+8");
        t.setToNow();
        y=t.year;
        m=t.month;
        d=t.monthDay;
        dd.init(y,m,d,this);
        tt.setIs24HourView(true);
        tt.setOnTimeChangedListener(this);
        t1.setText("日期:"+dd.getYear()+"/"+(dd.getMonth()+1)+"/"+(dd.getDayOfMonth()));
        t2.setText("時間:"+tt.getHour()+":"+tt.getMinute());
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
    }

    @Override
    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
        t1.setText("日期:"+i+"/"+(i1+1)+"/"+i2);
        if(i1 == 8 && i2 == 28){
            new AlertDialog.Builder(this).setIcon(android.R.drawable.btn_star_big_on)
                    .setTitle("祝福").setMessage("教師節快樂").show();
        }
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
        t2.setText("時間:"+i+":"+i1);
    }

    @Override
    public void onClick(View view) {
        if(view == t1){
            new DatePickerDialog(this,this,y,m,d).show();
        }
        if (view == t2){
            new TimePickerDialog(this,this,tt.getHour(),tt.getMinute(),true).show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int i, int i1, int i2) {
        t1.setText("日期:"+i+"/"+(i1+1)+"/"+i2);
        dd.init(i,i1,i2,this);
        if(i1 ==8 && i2 == 28){
            new AlertDialog.Builder(this).setIcon(android.R.drawable.btn_star_big_on)
                    .setTitle("祝福").setMessage("教師節快樂").show();
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int i, int i1) {
        t2.setText("時間:"+i+":"+i1);
    }

}