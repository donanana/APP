package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class UW16 extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener, View.OnClickListener{

    Spinner sp1,drk,tem,sug;
    ListView lv,lv2;
    String ca[]={"台北","華盛頓","東京","首爾"};
    String cou[]={"台灣","美國","日本","南韓"};
    String exer[]={"慢跑","游泳","健走","自行車"};
    String dr[]={"珍珠奶茶","波霸奶茶","仙草奶茶","檸檬汁"},
            st1[]={"冰","去冰","溫"},
            st2[]={"冰","去冰"};
    String st3[]={"一般","半糖","無糖"},
            st4[]={"一般","半糖"};
    TextView r;
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w16);
        sp1=(Spinner)findViewById(R.id.sp1);
        drk=(Spinner)findViewById(R.id.sp2);
        tem=(Spinner)findViewById(R.id.sp3);
        sug=(Spinner)findViewById(R.id.sp4);
        lv=(ListView)findViewById(R.id.list1);
        lv2=(ListView)findViewById(R.id.list2);
        r=(TextView)findViewById(R.id.tv);
        b=(Button)findViewById(R.id.button);
        ArrayAdapter<String> ap1=
                new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cou);
        sp1.setAdapter(ap1);
        ArrayAdapter<String> ap2=
                new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,ca);
        lv.setAdapter(ap2);
        ArrayAdapter<String> ap3=
                new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,exer);
        lv2.setAdapter(ap3);
        ArrayAdapter<String> ap4=
                new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,dr);
        drk.setAdapter(ap4);

        sp1.setOnItemSelectedListener(this);
        lv.setOnItemClickListener(this);
        lv2.setOnItemClickListener(this);
        drk.setOnItemSelectedListener(this);
        b.setOnClickListener(this);
    }
    ArrayList<String> se=new ArrayList<String>();
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView == lv) {
            sp1.setSelection(i);
            r.setText("國家："+cou[i]+"，其首都為"+ca[i]);
        }
        if (adapterView == lv2) {
            TextView t=(TextView)view;
            String ss=t.getText().toString();
            if (se.contains(ss)) se.remove(ss);
            else se.add(ss);
            String msg="";
            if (se.size()>0){
                msg="所選擇運動項目為";
                int i1=0;
                for (String k:se)
                    if (i1==0){
                        msg+=k;
                        i1=1;
                    }
                    else msg+="、"+k;
            }
            else msg="沒選擇！！";
            r.setText(msg);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView ==sp1){
            r.setText("國家："+cou[i]+"，其首都為"+ca[i]);
        }
        if (adapterView == drk){
            String t1[]={},t2[]={};
            if(i==3){
                t1=st2;
                t2=st4;
            }
            else{
                t1=st1;
                t2=st3;
            }
            ArrayAdapter<String> tt=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,t1);
            tem.setAdapter(tt);
            ArrayAdapter<String> sg=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,t2);
            sug.setAdapter(sg);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) { }

    public void onClick(View v) {
        String ms="訂購飲料為："+drk.getSelectedItem()+"、"+sug.getSelectedItem()+"、"+tem.getSelectedItem();
        r.setText(ms);
    }
}