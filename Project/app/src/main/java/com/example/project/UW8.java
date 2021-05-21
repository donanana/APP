package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UW8 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener, TextWatcher, View.OnClickListener {

    RadioGroup rg;
    RadioButton rc,rf;
    EditText te;
    TextView r;
    CheckBox c1,c2,c3,c4;
    Button b;
    int k=0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w8);
        r=(TextView)findViewById(R.id.res);

        rc=(RadioButton) findViewById(R.id.rc);
        rf=(RadioButton) findViewById(R.id.rf);

        te=(EditText) findViewById(R.id.etem);

        rg=(RadioGroup)findViewById(R.id.temper);

        rg.setOnCheckedChangeListener(this);
//        rc.setOnCheckedChangeListener(this);
//        rf.setOnCheckedChangeListener(this);
        te.addTextChangedListener(this);

        b=(Button) findViewById(R.id.button);
        c1=(CheckBox) findViewById(R.id.cham);
        c2=(CheckBox) findViewById(R.id.cfrench);
        c3=(CheckBox) findViewById(R.id.ccoke);
        c4=(CheckBox) findViewById(R.id.ccorn);

        b.setOnClickListener(this);
        c1.setOnCheckedChangeListener(this);
        c2.setOnCheckedChangeListener(this);
        c3.setOnCheckedChangeListener(this);
        c4.setOnCheckedChangeListener(this);
    }

    ArrayList<CompoundButton> collect=new ArrayList<CompoundButton>();
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//        if(compoundButton==rc && b){
//            String tes=te.getText().toString();
//            if(tes.length() !=0){
//                double cd=Double.parseDouble(tes),fd=9.0/5*cd+32;
//                r.setText("攝氏"+tes+getString(R.string.CC)+",華氏為"+String.format("%.2f",fd)+getString(R.string.FF));
//            }
//        }
//        if(compoundButton==rf && b){
//            String tes=te.getText().toString();
//            if(tes.length() !=0){
//                double fd=Double.parseDouble(tes), cd=(fd-32.0)*5.0/9;
//                r.setText("華氏"+tes+getString(R.string.FF)+",攝氏為"+String.format("%.2f",cd)+getString(R.string.CC));
//            }
//        }
        if (b) collect.add(compoundButton);
        else collect.remove(compoundButton);
    }

    public void onClick(View view) {
        String ms="";
        if(collect.size() == 0) {
            ms = "未訂餐!!!";
        } else {
            for (CompoundButton cp : collect) {
                if (k == 0) {
                    ms += cp.getText().toString();
                    k = 1;
                } else {
                    ms += "、" + cp.getText().toString();
                }
            }
        }
        r.setText(ms);
        k=0;
//        if (c1.isChecked()) ms+=c1.getText().toString()+"\n";
//        if (c2.isChecked()) ms+=c2.getText().toString()+"\n";
//        if (c3.isChecked()) ms+=c3.getText().toString()+"\n";
//        if (c4.isChecked()) ms+=c4.getText().toString()+"\n";
//        if (ms.length()==0) r.setText("未訂餐！！！");else r.setText(ms);

    }

    public  void calc(){
        if(rg.getCheckedRadioButtonId()==R.id.rc){
            String tes=te.getText().toString();
            if(tes.length() !=0){
                double cd=Double.parseDouble(tes),fd=9.0/5*cd+32;
                r.setText("攝氏"+tes+getString(R.string.CC)+",華氏為"+String.format("%.2f",fd)+getString(R.string.FF));
            }
        }
        if(rg.getCheckedRadioButtonId()==R.id.rf){
            String tes=te.getText().toString();
            if(tes.length() !=0){
                double fd=Double.parseDouble(tes), cd=(fd-32.0)*5.0/9;
                r.setText("華氏"+tes+getString(R.string.FF)+",攝氏為"+String.format("%.2f",cd)+getString(R.string.CC));
            }
        }
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    public void onTextChanged(CharSequence s, int start, int before, int count) { }

    public void afterTextChanged(Editable s) { calc(); }

    public void onCheckedChanged(RadioGroup group, int checkedId) { calc(); }
}