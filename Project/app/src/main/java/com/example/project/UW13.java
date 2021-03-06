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
                t.setText("??????"+m+"?????????");
            }
        }
        if (view == p){
            k=p.getProgress()+10;
            if(k > 80){
                k = 0;
            }
            p.setProgress(k);
            rb.setRating((float)k/10);
            t.setText("??????ProgressBar?????????"+k);

        }
    }

    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        e.setText(""+v);
        p.setProgress((int)(v*10));
        n.setValue((int)(v*10));
        sb.setProgress((int)(v*10));
        t.setText("??????"+v+"?????????");
    }

    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        rb.setRating((float)i1/10);
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(seekBar == sb){
            t.setText("????????????SEEK??????"+i);
            rb.setRating((float)i/10);
        }
        if(seekBar == red){
            ir=i;
            res.setText("???????????????"+ir);
        }
        if(seekBar == green){
            ig=i;
            res.setText("???????????????"+ig);
        }
        if(seekBar == blue){
            ib=i;
            res.setText("???????????????"+ib);
        }
        if(seekBar == red ||seekBar == green ||seekBar == blue){
            res.setBackgroundColor(Color.rgb(ir,ig,ib));
            res.setText("?????????????????????"+ir+"\n?????????????????????"+ig+"\n?????????????????????"+ib);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        t.setText("????????????SEEK??????"+seekBar.getProgress());
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        t.setText("????????????SEEK??????"+seekBar.getProgress());
    }
}