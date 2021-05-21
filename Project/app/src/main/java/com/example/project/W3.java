package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class W3 extends AppCompatActivity implements View.OnClickListener{

    Button b1;
    TextView t;
    String ff[]={"牛肉","豬肉","雞肉","羊肉"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w3);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(this);
        t=(TextView)findViewById(R.id.tv1);
    }

    @Override
    public void onClick(View view) {
        Intent it=new Intent();
        it.setClass(this,W3_2.class);
        it.putExtra("學生","wayne");
        it.putExtra("愛吃",ff);
        startActivity(it);
        String ss="學生：Wayne, 愛吃食物如下：\n";
        for (int i=0;i<ff.length;i++)
            if (i<ff.length-1) ss+=ff[i]+'、';else ss+=ff[i];
        t.setText(ss);
//        startActivity(new Intent(this,Second.class));
    }
}