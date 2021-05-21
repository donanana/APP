package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class W5 extends AppCompatActivity implements View.OnClickListener {

    Button bt1;
    EditText id,name;
    TextView m_res;
    String no,na;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w5);
            bt1=(Button)findViewById(R.id.b1);
            bt1.setOnClickListener(this);
            id=(EditText)findViewById(R.id.no2);
            name=(EditText)findViewById(R.id.name2);
            m_res=(TextView)findViewById(R.id.res);
            Intent it=getIntent();
            String result=it.getStringExtra("result");
            m_res.setText(result);
        }

        @Override
        public void onClick(View view) {
            if(view==bt1){
                Intent it=new Intent(this,W5_2.class);
                no=id.getText().toString();
                na=name.getText().toString();
                if (no.length() > 0 && na.length() > 0){
                    it.putExtra("學號",no);
                    it.putExtra("姓名",na);
                    startActivity(it);
                }else{
                    Toast.makeText(this,"有資料為空值",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }