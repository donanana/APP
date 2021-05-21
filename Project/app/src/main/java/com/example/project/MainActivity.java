package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout ub1,ub2,ub4,ub5,ub6,ub7,ub8,ub9,ub11,ub12,ub13,ub14,ub15,ub16,ub17;
    LinearLayout b1,b2,b3,b4,b5,b7,b8,b11,b12,b13,b14,b15,b16,b17;
    Button top1,top2;
    ScrollView sv1,sv2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ub1=(LinearLayout)findViewById(R.id.ub1);
        ub1.setOnClickListener(this);
        ub2=(LinearLayout)findViewById(R.id.ub2);
        ub2.setOnClickListener(this);
        ub4=(LinearLayout)findViewById(R.id.ub4);
        ub4.setOnClickListener(this);
        ub5=(LinearLayout)findViewById(R.id.ub5);
        ub5.setOnClickListener(this);
        ub6=(LinearLayout)findViewById(R.id.ub6);
        ub6.setOnClickListener(this);
        ub7=(LinearLayout)findViewById(R.id.ub7);
        ub7.setOnClickListener(this);
        ub8=(LinearLayout)findViewById(R.id.ub8);
        ub8.setOnClickListener(this);
        ub9=(LinearLayout)findViewById(R.id.ub9);
        ub9.setOnClickListener(this);
        ub11=(LinearLayout)findViewById(R.id.ub11);
        ub11.setOnClickListener(this);
        ub12=(LinearLayout)findViewById(R.id.ub12);
        ub12.setOnClickListener(this);
        ub13=(LinearLayout)findViewById(R.id.ub13);
        ub13.setOnClickListener(this);
        ub14=(LinearLayout)findViewById(R.id.ub14);
        ub14.setOnClickListener(this);
        ub15=(LinearLayout)findViewById(R.id.ub15);
        ub15.setOnClickListener(this);
        ub16=(LinearLayout)findViewById(R.id.ub16);
        ub16.setOnClickListener(this);
        ub17=(LinearLayout)findViewById(R.id.ub17);
        ub17.setOnClickListener(this);
        b1=(LinearLayout)findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2=(LinearLayout)findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3=(LinearLayout)findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4=(LinearLayout)findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5=(LinearLayout)findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b7=(LinearLayout)findViewById(R.id.b7);
        b7.setOnClickListener(this);
        b8=(LinearLayout)findViewById(R.id.b8);
        b8.setOnClickListener(this);
        b11=(LinearLayout)findViewById(R.id.b11);
        b11.setOnClickListener(this);
        b12=(LinearLayout)findViewById(R.id.b12);
        b12.setOnClickListener(this);
        b13=(LinearLayout)findViewById(R.id.b13);
        b13.setOnClickListener(this);
        top1=(Button)findViewById(R.id.top1);
        top1.setOnClickListener(this);
        top2=(Button)findViewById(R.id.top2);
        top2.setOnClickListener(this);
        sv1=(ScrollView) findViewById(R.id.sv1);
        sv2=(ScrollView)findViewById(R.id.sv2);
    }

    public void onClick(View view) {
        if (view == ub1)
            startActivity(new Intent(this,UW1.class));
        if (view == ub2)
            startActivity(new Intent(this,UW2.class));
        if (view == ub4)
            startActivity(new Intent(this,UW4.class));
        if (view == ub5)
            startActivity(new Intent(this,UW5.class));
        if (view == ub6)
            startActivity(new Intent(this,UW6.class));
        if (view == ub7)
            startActivity(new Intent(this,UW7.class));
        if (view == ub8)
            startActivity(new Intent(this,UW8.class));
        if (view == ub9)
            startActivity(new Intent(this,UW9.class));
        if (view == ub11)
            startActivity(new Intent(this,UW11.class));
        if (view == ub12)
            startActivity(new Intent(this,UW12.class));
        if (view == ub13)
            startActivity(new Intent(this,UW13.class));
        if (view == ub14)
            startActivity(new Intent(this,UW14.class));
        if (view == ub15)
            startActivity(new Intent(this,UW15.class));
        if (view == ub16)
            startActivity(new Intent(this,UW16.class));
        if (view == ub17)
            startActivity(new Intent(this,UW17.class));
        if (view == b1)
            startActivity(new Intent(this,W1.class));
        if (view == b2)
            startActivity(new Intent(this,W2.class));
        if (view == b3)
            startActivity(new Intent(this,W3.class));
        if (view == b4)
            startActivity(new Intent(this,W4.class));
        if (view == b5)
            startActivity(new Intent(this,W5.class));
        if (view == b7)
            startActivity(new Intent(this,W6.class));
        if (view == b8)
            startActivity(new Intent(this,W8.class));
        if (view == b11)
            startActivity(new Intent(this,W10.class));
        if (view == b12)
            startActivity(new Intent(this,W11.class));
        if (view == b13)
            startActivity(new Intent(this,W13.class));
        if (view == top1){
            top1.setEnabled(false);
            top2.setEnabled(true);
            sv1.setVisibility(View.VISIBLE);
            sv2.setVisibility(View.INVISIBLE);
        }
        if (view == top2){
            top1.setEnabled(true);
            top2.setEnabled(false);
            sv1.setVisibility(View.INVISIBLE);
            sv2.setVisibility(View.VISIBLE);
        }
    }
}