package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class UW4 extends AppCompatActivity implements View.OnClickListener{

    Button b1,b2,b3,b4,b5; int size=25; TextView rr, red, green, blue;
    //sol 1
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w4);

         b1=(Button)findViewById(R.id.button1);
         b2=(Button)findViewById(R.id.button2);
         b3=(Button)findViewById(R.id.button3);
         b4=(Button)findViewById(R.id.button4);
         b5=(Button)findViewById(R.id.button5);



         rr=(TextView)findViewById(R.id.res);
         red=(TextView)findViewById(R.id.red);
         green=(TextView)findViewById(R.id.green);
         blue=(TextView)findViewById(R.id.blue);


         b1.setOnClickListener(this);
         b2.setOnClickListener(this);
         b3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 size=25;
                 rr.setTextSize(size);
             }
         });

         //design->onClick->exit拿掉
//        b3.setOnClickListener(this);
//        b4.setOnClickListener(this);
         b5.setOnClickListener(this);
     }

    //sol 2
    public void exit(View v) { finish(); }

    //sol 3
    public void onClick(View view) {
        if (view == b1){
            if (size <= 52)
                size++;rr.setTextSize(size);rr.setText(getString(R.string.content)+"字型大小"+size);
        }
        if (view == b2){
            if (size >= 13)
                size--;rr.setTextSize(size); rr.setText(getString(R.string.content)+"字型大小"+size);
        }
        if (view == b3){size=25;rr.setTextSize(size); rr.setText(getString(R.string.content)+"字型大小"+size);}
        if (view == b4){finish(); }
        if (view == b5){
            Random ra=new Random();
            int r1=ra.nextInt(256);
            int g1=ra.nextInt(256);
            int b1=ra.nextInt(256);

            red.setText(getString(R.string.RED)+r1);
            green.setText(getString(R.string.GREEN)+g1);
            blue.setText(getString(R.string.BLUE)+b1);

            rr.setTextColor(Color.rgb(r1,g1,b1));

            red.setTextColor(Color.WHITE);
            red.setBackgroundColor(Color.rgb(r1,0,0));

            green.setTextColor(Color.WHITE);
            green.setBackgroundColor(Color.rgb(0,g1,0));

            blue.setTextColor(Color.WHITE);
            blue.setBackgroundColor(Color.rgb(0,0,b1));
        }
    }
}