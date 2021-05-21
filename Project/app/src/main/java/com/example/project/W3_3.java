package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class W3_3 extends AppCompatActivity implements View.OnClickListener{

    Button b4,b5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w3_3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);

        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == b5)finish();
        if (view == b4) {
//            Intent it=new Intent();
//            it.setClass(this,MainActivity.class);
            startActivity(new Intent(this,W3.class));
        }
    }
}