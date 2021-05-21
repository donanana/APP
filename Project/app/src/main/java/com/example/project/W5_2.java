package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class W5_2 extends AppCompatActivity implements View.OnClickListener{

    Button bt2;
    TextView rr;
    String stu_id,stu_name;
    EditText chi,eng,mat;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w5_2);
        Intent it=getIntent();
        stu_id=it.getStringExtra("學號");
        stu_name=it.getStringExtra("姓名");
        String tmp="收到學號："+stu_id+"\n姓名："+stu_name;
        rr=(TextView)findViewById(R.id.res2);
        rr.setText(tmp);
        bt2=(Button)findViewById(R.id.b2);
        bt2.setOnClickListener(this);
        chi=(EditText)findViewById(R.id.name3);
        eng=(EditText)findViewById(R.id.name4);
        mat=(EditText)findViewById(R.id.name5);
    }

    @Override
    public void onClick(View view) {
        if (view == bt2){
            Intent it=new Intent(this,W5.class);
            String ch=chi.getText().toString();
            String en=eng.getText().toString();
            String ma=mat.getText().toString();
            if (ch.length() > 0 && en.length() > 0 && ma.length() > 0){
                double c = Double.parseDouble(ch),e = Double.parseDouble(en),m = Double.parseDouble(ma);
                double avg = (c+e+m)/3.0;
                double total = (c+e+m);
                String tmp = "顯示結果：\n學號："+stu_id+"\n學號："+stu_name+"\n國文："+c+"\n英文："+e+"\n數學："+m+"\n平均："+String.format("%.2f",avg);
                if (avg>=85){
                    tmp+="\n成績很好可得獎學金10000元！";
                }else if (avg>=75){
                    tmp+="\n成績不錯可得獎學金5000元！";
                }else{
                    tmp+="\n成績普通，還要再努力！";
                }
                Toast.makeText(this,tmp,Toast.LENGTH_SHORT).show();
                rr.setText(tmp);
                it.putExtra("result",tmp);
                startActivity(it);
            }else{
                Toast.makeText(this,"有資料為空值",Toast.LENGTH_SHORT).show();
            }

        }
    }
}