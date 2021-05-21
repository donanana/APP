package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class W10 extends AppCompatActivity implements TabHost.OnTabChangeListener, View.OnClickListener{

    TabHost tb;
    Button b1,b2;
    TextView res;
    MediaPlayer mp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w10);
        tb=(TabHost)findViewById(R.id.tabh);
        tb.setup();
        b1=(Button)findViewById(R.id.bt);
        b2=(Button)findViewById(R.id.b2);
        TabHost.TabSpec ss=tb.newTabSpec("tab1");
        ss.setContent(R.id.tab1);
        ss.setIndicator("計算BMI");
        tb.addTab(ss);

        ss=tb.newTabSpec("tab2");
        ss.setContent(R.id.tab2); ss.setIndicator("BMI計算說明");

        tb.addTab(ss);
        tb.setCurrentTab(1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        mp=new MediaPlayer();
//        mp.reset();
        mp=MediaPlayer.create(this,R.raw.welcome);
        mp.start();
    }

    @Override
    public void onTabChanged(String s) {
        Toast.makeText(this, "切換分頁資料分頁標記:"+s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if (view == b1){
            EditText e1=(EditText)findViewById(R.id.ed1);
            EditText e2=(EditText)findViewById(R.id.ed2);
            TextView rr=(TextView)findViewById(R.id.rr);
            String s1=e1.getText().toString(),s2=e2.getText().toString();
            if (s1.length()>0 && s2.length()>0){
                double h=Double.parseDouble(s1)/100.0, w=Double.parseDouble(s2),bmi=w/(h*h);
                rr.setText("結果：BMI="+String.format("%.2f",bmi));
            }else{
                Toast.makeText(this,"身高或體重未輸入！！！",Toast.LENGTH_SHORT).show();
            }
        }
        if (view == b2){
            mp.start();;
        }
    }
}