package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class UW14 extends AppCompatActivity implements View.OnClickListener, Spinner.OnItemSelectedListener {
    TextView r;
    Button b1,b2,b3;
    WebView w1,w2;
    gemV g;
    Spinner sp;
    String ar[];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w14);
        r=(TextView)findViewById(R.id.tv);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        w1=(WebView)findViewById(R.id.ww1);
        w2=(WebView)findViewById(R.id.ww2);
        g=(gemV)findViewById(R.id.gem);
        sp=(Spinner)findViewById(R.id.spinner);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        w1.setBackgroundColor(Color.GRAY);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        ar=getResources().getStringArray(R.array.sea);
        r.setText("您選了第"+i+"項, 內容為"+ar[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View view) {
        if (view == b1){
            String data="<html><head>"+"<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">"+
                    "</head><body>私立淡江大學<b>資訊工程系</b></body></html>";
            w1.loadData(data,"text/html; charset=UTF-8",null);
            w2.loadUrl("http://www.csie.tku.edu.tw");
        }
        if (view == b2){
            String data="<html><head>"+"<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">"+
                    "</head><body>國立中央大學<b>通訊工程系</b></body></html>";
            w1.loadData(data,"text/html; charset=UTF-8",null);
            w2.loadUrl("https://www.csie.ncu.edu.tw");
        }
        if (view == b3){
            g.invalidate();
            sp.setSelection(3);
        }
    }


}