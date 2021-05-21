package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UW15 extends AppCompatActivity implements Spinner.OnItemSelectedListener , View.OnClickListener{

    TextView r,exer;
    Spinner sp1,sp2,sp3,sp4;
    Button b;
    double consume=0.0;
    double com[]={3.1,4.4,13.2,9.7,5.1,3.7};
    String c1[]={"台灣","美國","日本","英國","南韓"},c2[]={"台本","華盛頓","東京","倫敦","首爾"};
    String ex[]={"慢走","快走或游泳","跑步","自行車","羽毛球","高爾夫"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w15);
        r=(TextView)findViewById(R.id.tv);
        sp1 = (Spinner)findViewById(R.id.sp1);
        sp2 = (Spinner)findViewById(R.id.sp_cou);
        sp3 = (Spinner)findViewById(R.id.sp_cap);
        sp4 = (Spinner)findViewById(R.id.sp4);
        b=(Button)findViewById(R.id.bt);
        exer=(TextView)findViewById(R.id.exer_res);
        sp1.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);
        sp3.setOnItemSelectedListener(this);
        sp4.setOnItemSelectedListener(this);
        b.setOnClickListener(this);

        ArrayAdapter<String> ap1=new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,c1);
        sp2.setAdapter(ap1);
        ArrayAdapter<String> ap2=new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,c2);
        sp3.setAdapter(ap2);
        ArrayAdapter<String> ap3=new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,ex);
        sp4.setAdapter(ap3);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView == sp1){
            String ar[]=getResources().getStringArray(R.array.sea);
            String str="";
            for(String k:ar) str+=k+"\n";
            r.setText(str+"選到第"+sp1.getSelectedItemPosition()+"位置，內容為"+sp1.getSelectedItem());
        }
        if(adapterView == sp2){
            r.setText("選到國家為"+sp2.getSelectedItem()+"其首都為"+c2[i]+"\n");
            sp2.setSelection(i);
        }
        if(adapterView == sp3){
            r.setText("選到首都為"+sp3.getSelectedItem()+"其國家為"+c1[i]+"\n");
            sp3.setSelection(i);
        }
        if(adapterView == sp4){
            r.setText("選到運動為"+sp4.getSelectedItem()+"其消耗為"+com[i]+"\n");
            exer.setText("選擇運動項目消耗（千卡/公斤)："+com[i]);
            consume=com[i];
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }

    @Override
    public void onClick(View v) {
        EditText w=(EditText)findViewById(R.id.wei);
        EditText ti=(EditText)findViewById(R.id.hour);
        String ww=w.getText().toString(),tt=ti.getText().toString();
        if(ww.length()!=0 && tt.length()!=0) {
            consume=consume*Double.parseDouble(ww)*Double.parseDouble(tt);
            r.setText("選到運動為"+sp4.getSelectedItem()+
                    "總消耗熱量"+String.format("%.2f",consume)+"仟卡");
        }
        else r.setText("體重或運動時間未輸入");
    }
}