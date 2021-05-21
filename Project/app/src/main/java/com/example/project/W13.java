package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

public class W13 extends AppCompatActivity implements MediaPlayer.OnCompletionListener,MediaPlayer.OnErrorListener{

    Uri u;
    VideoView vdv;
    int pos=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w13);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        vdv=(VideoView)findViewById(R.id.videoView);
        u=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.iu);
//        u=Uri.parse("https://youtu.be/d9IxdwEFk1c");
        MediaController m=new MediaController(this);
        vdv.setMediaController(m);
        vdv.setVideoURI(u);
        vdv.start();
        vdv.requestFocus();
        vdv.setOnCompletionListener(this);
        vdv.setOnErrorListener(this);
        m.setPrevNextListeners(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(W13.this,"下一個影片",Toast.LENGTH_LONG).show();
                u=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.iu2);
                vdv.setVideoURI(u);
            }
        }, new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(W13.this,"前一個影片",Toast.LENGTH_LONG).show();
                u=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.iu);
                vdv.setVideoURI(u);
            }
        });
        setdisp(0);
    }

    public void setdisp (int para){
        RelativeLayout.LayoutParams pa=null;
        if (para == 1){
            pa=new RelativeLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            pa.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            pa.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            pa.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            pa.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            vdv.setLayoutParams(pa);
        }else{
            DisplayMetrics dm=new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            int vh=dm.heightPixels-50,vw=dm.widthPixels-50;
            pa=new RelativeLayout.LayoutParams(vw,vh);
            pa.addRule(RelativeLayout.CENTER_IN_PARENT);
        }
        vdv.setLayoutParams(pa);
    }
    protected void onStart() {
        super.onStart();
        vdv.start();
        vdv.requestFocus();
        Log.d("debug","開始播放!!");
    }

    protected void onPause() {
        super.onPause();
        pos=vdv.getCurrentPosition();
        vdv.stopPlayback();
        Log.d("debug","暫停播放!!");
    }

    protected void onResume() {
        super.onResume();
        if(pos>=0){
            vdv.seekTo(pos);
            vdv.start();
            pos=-1;
        }
        Log.d("debug","繼續播放!!");
    }

    public void onCompletion(MediaPlayer mp) {
        Log.d("debug","播放完成!!");
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        Log.d("debug","播放錯誤!!");
        return false;
    }
}