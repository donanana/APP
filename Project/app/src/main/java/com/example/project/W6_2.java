package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class W6_2 extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2;
    EditText ed;
    int pos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w6_2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        ed=(EditText) findViewById(R.id.memo);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        Intent it = getIntent();
        String s = it.getStringExtra("內容");
        ed.setText(s);
        pos = Integer.parseInt(s.substring(0,1));
        Toast.makeText(this,pos+"",Toast.LENGTH_LONG).show();
    }

    public void onClick(View view) {
        if (view == b2){
            setResult(RESULT_CANCELED);
            finish();
        }
        if (view == b1){
            String s=ed.getText().toString();
            if (ed.length()>=2){
                ed.setText(s);
            }else{
                ed.setText(pos+".");
                s=pos+".";
            }
            Intent it = new Intent();
            it.putExtra("內容",s);
            it.putExtra("日期",new Date().toString());
            setResult(RESULT_OK,it);
            finish();
        }
    }
}