package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class UW11 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener , View.OnClickListener{

    int ch[]={R.id.chH,R.id.chF,R.id.chC,R.id.chS};
    Button b1,b2,b3;
    TextView r;
    int im[]={R.id.imHam,R.id.imFre,R.id.imCoke,R.id.imSoup};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w11);
        for (int i:ch){
            CheckBox c=(CheckBox)findViewById(i);
            c.setOnCheckedChangeListener(this);
        }
        r=(TextView)findViewById(R.id.res);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);
        b3=(Button)findViewById(R.id.bt3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    int item = 0;
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int vis;
        if (b){
            item ++;
            vis=View.VISIBLE;
        }else{
            item--;
            vis=View.GONE;
        }
        switch (compoundButton.getId()){
            case R.id.chH:
                ImageView v1=(ImageView)findViewById(R.id.imHam);
                v1.setVisibility(vis);
                break;

            case R.id.chF:
                ImageView v2=(ImageView)findViewById(R.id.imFre);
                v2.setVisibility(vis);
                break;

            case R.id.chC:
                ImageView v3=(ImageView)findViewById(R.id.imCoke);
                v3.setVisibility(vis);
                break;

            case R.id.chS:
                ImageView v4=(ImageView)findViewById(R.id.imSoup);
                v4.setVisibility(vis);
                break;
        }
    }

    public void onClick(View view) {
        if(view==b1){
            String m = "";
            if (item == 0){
                m="未點選任何餐點，請點餐！";
            }else{
                m="點餐結果:";
                int i = 0;
                for (int j:ch){
                    CheckBox c = (CheckBox)findViewById(j);
                    if (c.isChecked()){
                        if(i == 0){
                            m += c.getText().toString();
                            i = 1;
                        }else{
                            m += "、" + c.getText().toString();
                        }
                    }
                }
            }
            r.setText(m);
        }
        if(view == b2){
            for (int i:ch) ((CheckBox)findViewById(i)).setChecked(false);
            for (int i:im) ((ImageView)findViewById(i)).setVisibility(View.GONE);
            r.setText("點餐結果：");
        }

        if(view == b3) {
            finish();
        }
    }
}