package com.example.project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class UW12 extends AppCompatActivity implements View.OnDragListener,View.OnLongClickListener,View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    TextView t1;
    ImageView iv1,iv2,iv3;
    Button b;
    ImageButton ig;
    EditText e;
    ToggleButton tg;
    Switch ss;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w12);
        t1=(TextView)findViewById(R.id.tv);
        iv1=(ImageView)findViewById(R.id.imageView1);
        iv2=(ImageView)findViewById(R.id.imageView2);
        iv3=(ImageView)findViewById(R.id.imageView3);
        b=(Button)findViewById(R.id.button);
        ig=(ImageButton)findViewById(R.id.imageButton);
        tg=(ToggleButton)findViewById(R.id.tgb);
        ss=(Switch)findViewById(R.id.switch1);
        e=(EditText)findViewById(R.id.ename);

        iv1.setOnLongClickListener(this);
        iv2.setOnLongClickListener(this);
        iv3.setOnLongClickListener(this);
        iv1.setOnDragListener(this);
        iv2.setOnDragListener(this);
        iv3.setOnDragListener(this);

        b.setOnClickListener(this);
        ig.setOnClickListener(this);
        tg.setOnClickListener(this);
        ss.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton == ss){
            String m=e.getText().toString();
            if (m.length()!=0){
                if (b){
                    t1.setText(m + ss.getTextOn());
                    tg.setChecked(true);
                    ss.setText(ss.getTextOn());
                }else {
                    t1.setText(m + ss.getTextOff());
                    tg.setChecked(false);
                    ss.setText(ss.getTextOff());
                }
            }
            else t1.setText("未輸入姓名！！");
        }
    }

    @Override
    public void onClick(View view) {
        if (view == tg||view==b||view==ig){
            String m=e.getText().toString();
            if (m.length()!=0){
                if (tg.isChecked()){
                    t1.setText(m + tg.getTextOn());
                    ss.setChecked(true);
                    ss.setText(ss.getTextOn());
                }else {
                    t1.setText(m + tg.getTextOff());
                    ss.setChecked(false);
                    ss.setText(ss.getTextOff());
                }
            }
            else t1.setText("未輸入姓名！！");
        }
    }

    public boolean onDrag(View view, DragEvent dragEvent) {
        ImageView t=(ImageView)view;
        int x=(int)dragEvent.getX(),y=(int)dragEvent.getY();
        String msg="";
        switch (dragEvent.getAction()){
            case DragEvent.ACTION_DRAG_STARTED:
                msg = "開始";
                t.setColorFilter(Color.BLUE);
                break;

            case DragEvent.ACTION_DRAG_ENTERED:
                msg = "進入";
                t.setColorFilter(Color.RED);
                break;

            case DragEvent.ACTION_DRAG_EXITED:
                msg = "離開";
                t.setColorFilter(Color.GREEN);
                break;

            case DragEvent.ACTION_DRAG_ENDED:
                msg = "結束";
                t.clearColorFilter();
                break;

            case DragEvent.ACTION_DROP:
                msg = "放下";
                ImageView s = (ImageView)dragEvent.getLocalState();
                Drawable im=s.getDrawable();
                s.setImageDrawable(t.getDrawable());
                t.setImageDrawable(im);
                break;
        }
        msg += "("+x+","+y+")";
        t1.setText(msg);
        setTitle(msg);
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean onLongClick(View view) {
        view.startDragAndDrop(null,new View.DragShadowBuilder(view),view,0);
        return true;
    }



}