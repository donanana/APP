package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class W1 extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    Button b;
    TextView t1,t2;
    Time t;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w1);
        new AlertDialog.Builder(this).setTitle("歡迎")
                .setCancelable(true).setMessage("示範視窗教學")
                .setPositiveButton("正面",this)
                .setNegativeButton("負面",this)
                .setNeutralButton("中性",this)
                .setIcon(android.R.drawable.presence_away).show();
        b=(Button)findViewById(R.id.bt1);
        b.setOnClickListener(this);
        t1=(TextView)findViewById(R.id.tv1);
        t2=(TextView)findViewById(R.id.tv2);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t=new Time();
        t.setToNow();
        new DatePickerDialog(this,this,t.year,t.month,t.monthDay).show();
        new TimePickerDialog(this,this,t.hour,t.minute,false).show();

    }

    @Override
    public void onClick(View view) {
        if (view == b)
            new AlertDialog.Builder(this).setTitle("歡迎")
                    .setCancelable(false).setMessage("示範視窗教學")
                    .setPositiveButton("正面", this)
                    .setNegativeButton("負面", this)
                    .setNeutralButton("中性", this)
                    .setIcon(android.R.drawable.presence_away).show();
        if(view == t1)
            new DatePickerDialog(this,this,t.year,t.month,t.monthDay).show();
        if(view == t2)
            new TimePickerDialog(this,this,t.hour,t.minute,true).show();

    }

    @Override
    public void onClick(DialogInterface dialog, int i) {
        if(i == DialogInterface.BUTTON_POSITIVE) t1.setText("您選了正面");
        if(i == DialogInterface.BUTTON_NEGATIVE) t1.setText("您選了負面");
        if(i == DialogInterface.BUTTON_NEUTRAL) t1.setText("您選了中性");

    }

    @Override
    public void onDateSet(DatePicker view, int i, int i1, int i2) {
        t1.setText("日期："+i+"/"+(i1+1)+"/"+i2);
    }

    @Override
    public void onTimeSet(TimePicker view, int i, int i1) {
        if(i >12)
            t2.setText("時間：下午"+(i-12)+":"+i1);
        else
            t2.setText("時間：上午"+i+":"+i1);

    }
}