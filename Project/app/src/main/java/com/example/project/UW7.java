package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;

public class UW7 extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {

    Button b1;
    TextView t1;
    EditText name;
    RadioGroup r,f;
    RadioButton m,w,rn,rb,ri,rib;
    Typeface tf;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w7);
        b1 = (Button)findViewById(R.id.button);
        t1 = (TextView)findViewById(R.id.res);
        name = (EditText)findViewById(R.id.edit1);

        b1.setOnClickListener(this);

        r = (RadioGroup)findViewById(R.id.rg);
        m=(RadioButton)findViewById(R.id.rman);
        w=(RadioButton)findViewById(R.id.rwoman);

        f = (RadioGroup)findViewById(R.id.font);
        rb=(RadioButton)findViewById(R.id.rbold);
        ri=(RadioButton)findViewById(R.id.ritalic);
        rn=(RadioButton)findViewById(R.id.rnomal);
        rib=(RadioButton)findViewById(R.id.rboita);

        m.setOnCheckedChangeListener(this);
        w.setOnCheckedChangeListener(this);
        rn.setOnCheckedChangeListener(this);
        rb.setOnCheckedChangeListener(this);
        ri.setOnCheckedChangeListener(this);
        rib.setOnCheckedChangeListener(this);

        tf = t1.getTypeface();
        t1.setText(getString(R.string.C));
    }

    @Override
    public void onClick(View view) {
        String s=name.getText().toString();
        if (s.length() !=0) {
            switch (r.getCheckedRadioButtonId()) {
                case R.id.rman:
                    t1.setText(s + "先生您好");
                    break;
                case R.id.rwoman:
                    t1.setText(s + "小姐您好");
                    break;
            }
        }
        else Toast.makeText(this,"未輸入姓名",Toast.LENGTH_SHORT).show();

        switch (f.getCheckedRadioButtonId()){
            case R.id.rbold: t1.setTypeface(t1.getTypeface(),Typeface.BOLD); break;
            case R.id.ritalic: t1.setTypeface(t1.getTypeface(),Typeface.ITALIC); break;
            case R.id.rboita: t1.setTypeface(t1.getTypeface(),Typeface.BOLD_ITALIC); break;
            case R.id.rnomal: t1.setTypeface(tf); break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String s = name.getText().toString();
        if(b) {
            if (s.length() !=0) {
                if (compoundButton == m)
                    t1.setText(s + "先生您好");
                if (compoundButton == w)
                    t1.setText(s + "小姐您好");
            }

            else Toast.makeText(this,"未輸入姓名",Toast.LENGTH_SHORT).show();

            if (compoundButton == rb)
                t1.setTypeface(t1.getTypeface(), Typeface.BOLD);
            if (compoundButton == ri)
                t1.setTypeface(t1.getTypeface(), Typeface.ITALIC);
            if (compoundButton == rib)
                t1.setTypeface(t1.getTypeface(), Typeface.BOLD_ITALIC);
            if (compoundButton == rn)
                t1.setTypeface(tf);
        }
    }
}