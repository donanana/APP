package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class UW13 extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener, View.OnClickListener, NumberPicker.OnValueChangeListener, SeekBar.OnSeekBarChangeListener {

    TextView t,res;
    RatingBar rb;
    EditText e;
    Button b;
    NumberPicker n;
    ProgressBar p;
    SeekBar sb,red,green,blue;
    int k,ir,ig,ib;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w13);
        res=(TextView) findViewById(R.id.colorCh);
        t=(TextView)findViewById(R.id.tv);
        rb=(RatingBar)findViewById(R.id.rb);
        e=(EditText)findViewById(R.id.enu);
        b=(Button)findViewById(R.id.b1);
        n=(NumberPicker)findViewById(R.id.np);
        p=(ProgressBar)findViewById(R.id.pb);
        sb=(SeekBar)findViewById(R.id.sb);
        red=(SeekBar)findViewById(R.id.sred);
        green=(SeekBar)findViewById(R.id.sgreen);
        blue=(SeekBar)findViewById(R.id.sblue);

        res.setTextColor(Color.WHITE);

        rb.setOnRatingBarChangeListener(this);
        b.setOnClickListener(this);
        n.setOnValueChangedListener(this);
        p.setOnClickListener(this);
        sb.setOnSeekBarChangeListener(this);
        red.setOnSeekBarChangeListener(this);
        green.setOnSeekBarChangeListener(this);
        blue.setOnSeekBarChangeListener(this);

        n.setMinValue(0);
        n.setMaxValue(80);
        n.setWrapSelectorWheel(false);

    }

    public void onClick(View view) {
        if (view == b){
            String s=e.getText().toString();
            if (e.length()!=0){
                float m=Float.parseFloat(s);
                rb.setRating((float) m);
                p.setProgress((int)(m*10));
                t.setText("點選"+m+"個星星");
            }
        }
        if (view == p){
            k=p.getProgress()+10;
            if(k > 80){
                k = 0;
            }
            p.setProgress(k);
            rb.setRating((float)k/10);
            t.setText("設定ProgressBar值為："+k);

        }
    }

    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        e.setText(""+v);
        p.setProgress((int)(v*10));
        n.setValue((int)(v*10));
        sb.setProgress((int)(v*10));
        t.setText("點選"+v+"個星星");
    }

    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        rb.setRating((float)i1/10);
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(seekBar == sb){
            t.setText("正在拉動SEEK值為"+i);
            rb.setRating((float)i/10);
        }
        if(seekBar == red){
            ir=i;
            res.setText("紅色強度："+ir);
        }
        if(seekBar == green){
            ig=i;
            res.setText("綠色強度："+ig);
        }
        if(seekBar == blue){
            ib=i;
            res.setText("藍色強度："+ib);
        }
        if(seekBar == red ||seekBar == green ||seekBar == blue){
            res.setBackgroundColor(Color.rgb(ir,ig,ib));
            res.setText("選擇紅色強度："+ir+"\n選擇綠色強度："+ig+"\n選擇藍色強度："+ib);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        t.setText("開始拉動SEEK值為"+seekBar.getProgress());
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        t.setText("結束拉動SEEK值為"+seekBar.getProgress());
    }
}