package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class UW9 extends AppCompatActivity implements View.OnClickListener{

    Button b1,b2,b3;
    TextView r;
    CheckBox c1,c2,c3;
    int hi = 0;
    int fi = 0;
    int ci = 0;
    RadioButton hb, hm, hs, cb, cm, cs, fb, fm, fs;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w9);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        c1=(CheckBox)findViewById(R.id.chH);
        c2=(CheckBox)findViewById(R.id.chF);
        c3=(CheckBox)findViewById(R.id.chC);
        r=(TextView)findViewById(R.id.res);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        r.setText("請點餐");
        hb = (RadioButton)findViewById(R.id.Hb);
        hm = (RadioButton)findViewById(R.id.Hm);
        hs = (RadioButton)findViewById(R.id.Hs);
        cb = (RadioButton)findViewById(R.id.Cb);
        cm = (RadioButton)findViewById(R.id.Cm);
        cs = (RadioButton)findViewById(R.id.Cs);
        fb = (RadioButton)findViewById(R.id.Fb);
        fm = (RadioButton)findViewById(R.id.Fm);
        fs = (RadioButton)findViewById(R.id.Fs);
    }

    @Override
    public void onClick(View view) {
        if(view == b2) finish();
        if(b3 == view) {
            r.setText("請點餐！");
            c1.setChecked(false);
            c2.setChecked(false);
            c3.setChecked(false);
            hi=fi=ci=0;
            hb.setChecked(true);
            fb.setChecked(true);
            cb.setChecked(true);
        }
        if(b1==view){
            int money = 0;
            int hh[]={100,90,80},ff[]={60,50,40},cc[]={40,30,20};
            String s="點餐內容如下：\n";
            if (c1.isChecked()){
                s += c1.getText().toString();
                if(hb.isChecked()){
                    s+= "大號";
                    hi = 0;
                }else if (hm.isChecked()){
                    s+= "中號";
                    hi = 1;
                }else if(hs.isChecked()){
                    s+= "小號";
                    hi = 2;
                }
                s += "\n";
                money += hh[hi];
            }
            if (c2.isChecked()){
                s += c2.getText().toString();
                if(fb.isChecked()){
                    s+= "大號";
                    fi = 0;
                }else if (fm.isChecked()){
                    s+= "中號";
                    fi = 1;
                }else if(fs.isChecked()){
                    s+= "小號";
                    fi = 2;
                }
                s += "\n";
                money += ff[fi];
            }
            if (c3.isChecked()){
                s += c3.getText().toString();
                if(cb.isChecked()){
                    s+= "大號";
                    ci = 0;
                }else if (cm.isChecked()){
                    s+= "中號";
                    ci = 1;
                }else if(cs.isChecked()){
                    s+= "小號";
                    ci = 2;
                }
                s += "\n";
                money += cc[ci];
            }
            if(s.length() == 0) r.setText("您未訂購餐點");
            else r.setText((s+"應付: " + money + "元"));
        }
    }

//    @Override
//    public void onCheckedChanged(RadioGroup radioGroup, int i) {
//        if(c1.isChecked()) {
//            Toast.makeText(this, c1.getText().toString() +
//                    ((i == R.id.Hb) ? "大份" : (i == R.id.Hm) ? "中份" : "小份") + "被點選", Toast.LENGTH_SHORT).show();
//            hi = (i == R.id.Hb) ? 0: (i == R.id.Hm) ? 1 : 2;
//        }
//        if(c2.isChecked()) {
//            Toast.makeText(this, c2.getText().toString() +
//                    ((i == R.id.Fb) ? "大份" : (i == R.id.Fm) ? "中份" : "小份") + "被點選", Toast.LENGTH_SHORT).show();
//            fi = (i == R.id.Fb) ? 0: (i == R.id.Fm) ? 1 : 2;
//        }
//        if(c3.isChecked()) {
//            Toast.makeText(this, c3.getText().toString() +
//                    ((i == R.id.Cb) ? "大份" : (i == R.id.Cm) ? "中份" : "小份") + "被點選", Toast.LENGTH_SHORT).show();
//            ci = (i == R.id.Cb) ? 0: (i == R.id.Cm) ? 1 : 2;
//        }
//    }
}