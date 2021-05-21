package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UW6 extends AppCompatActivity implements View.OnClickListener ,View.OnLongClickListener, OnTouchListener{

    LinearLayout L,LI;
    TextView r;
    Button b[];
    EditText ed[];
    int c = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w6);
//        Log.v("test", "除錯測試前");
//        String ss="this is";
//        Toast.makeText(this,ss,Toast.LENGTH_SHORT).show();
//        char a=(char)ss.charAt(-1);
//        Log.v("test", "除錯測試後");

        r=(TextView)findViewById(R.id.res);
        L=(LinearLayout)findViewById(R.id.L1);
        b=new Button[20];
        ed=new EditText[20];
        LI=(LinearLayout)findViewById(R.id.LL);
        r.setOnClickListener(this);
        r.setOnLongClickListener(this);

        for (int i=0;i<20;i++){
            ed[i]=new EditText(this);
            ed[i].setHint("文字方塊"+(i+1));

            b[i]=new Button(this);
            b[i].setText("按鈕"+(i+1));

            LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            b[i].setOnClickListener(this);
            b[i].setOnLongClickListener(this);
            L.addView(ed[i],p);
            L.addView(b[i],p);
        }
        L.setOnTouchListener(this);
    }

    public void onClick(View view) {
        if(view == r)r.setText(""+c++);
        for (int i=0;i<20;i++){

            if (i == 0) {
                Log.v("test", "除錯測試Verbose");
                Log.d("test", "除錯測試Debug");
                Log.i("test", "除錯測試Information");
                Log.w("test", "除錯測試Warring");
                Log.e("test", "除錯測試Error");
            }

            if (view == b[i]){
                String s=ed[i].getText().toString();
                if(s.length() != 0) r.setText(s);
            }
        }
    }

    public boolean onLongClick(View view) {
        if(view == r){
            r.setText("0");
            c=0;
        }
        for (int i=0;i<20;i++)
            if (view == b[i]){
                r.setText("0");
                c=0;
            }
        return true;
    }


    public boolean onTouch(View view, MotionEvent motionEvent) {
        Vibrator vb=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        int  x=(int)motionEvent.getX(),y=(int)motionEvent.getY();

        if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
            r.setText("壓下("+x+","+y+")");
            setTitle("壓下("+x+","+y+")");
        }

        if (motionEvent.getAction()==MotionEvent.ACTION_UP){
            r.setText("放開("+x+","+y+")");
            setTitle("放開("+x+","+y+")");
        }

        if (motionEvent.getAction()==MotionEvent.ACTION_MOVE){
            r.setText("移動("+x+","+y+")");
            setTitle("移動("+x+","+y+")");
        }

        return true;
    }
}