package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class W3_2 extends AppCompatActivity implements View.OnClickListener{

    Button b2,b3;
    TextView rr;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w3_2);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        rr=(TextView) findViewById(R.id.res);
        Intent it=getIntent();
        String name=it.getStringExtra("學生");
        String eat[]=it.getStringArrayExtra("愛吃");
        String ss="學生：Wayne, 愛吃食物如下：\n";
        for (int i=0;i<eat.length;i++)
            if (i<eat.length-1) ss+=eat[i]+'、';else ss+=eat[i];
        rr.setText(ss);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == b3)finish();
        if (view == b2) {
            startActivity(new Intent(this,W3_3.class));
        }
    }
}