package com.example.project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class gemV extends View{
    ShapeDrawable sh[];
    public gemV(Context context){
        super(context);
    }
    public gemV(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
        drawsh();
    }
    public void drawsh(){
        sh=new ShapeDrawable[6];
        sh[0]=new ShapeDrawable(new OvalShape());
        sh[0].setBounds(10,10,100,150);
        sh[1]=new ShapeDrawable(new OvalShape());
        sh[1].setBounds(120,10,260,100);
        sh[2]=new ShapeDrawable(new OvalShape());
        sh[2].setBounds(300,10,400,150);
        sh[3]=new ShapeDrawable(new RectShape());
        sh[3].setBounds(10,170,100,310);
        sh[4]=new ShapeDrawable(new RectShape());
        sh[4].setBounds(120,170,260,260);
        sh[5]=new ShapeDrawable(new RectShape());
        sh[5].setBounds(300,170,400,310);
    }
    protected void onDraw(Canvas canvas){
        for(ShapeDrawable ss:sh){
            int r = (int)(Math.random()*256),g = (int)(Math.random()*256),b = (int)(Math.random()*256);
            ss.getPaint().setARGB(255,r,g,b);
            ss.draw(canvas);
        }
    }
}
