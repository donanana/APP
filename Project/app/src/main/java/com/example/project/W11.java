package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class W11 extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener,MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener{

    MediaPlayer mp;
    Button start,pause,stop,dest;
    TextView r1,r2;
    MediaController mc1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w11);
        mp=MediaPlayer.create(this,R.raw.welcome);
        start=(Button)findViewById(R.id.b1);
        pause=(Button)findViewById(R.id.b2);
        stop=(Button)findViewById(R.id.b3);
        dest=(Button)findViewById(R.id.b4);
        r1=(TextView)findViewById(R.id.res1);
        r2=(TextView)findViewById(R.id.res2);
        mc1=new MediaController(this);

        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        dest.setOnClickListener(this);
        start.setEnabled(true);
        stop.setEnabled(false);
        pause.setEnabled(false);
        dest.setEnabled(false);
        mp=new MediaPlayer();
        mp.setOnCompletionListener(this);
        mp.setOnErrorListener(this);
        mp.setOnPreparedListener(this);
        Toast.makeText(this,"android.resource://"+getPackageName()+"/Music/welcome.mp3",Toast.LENGTH_LONG).show();
        try{
            mp.reset();
            Uri u= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.welcome);
            mp.setDataSource(this,u);
//            mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/Music/welcome.mp3");
//            mp=MediaPlayer.create(this,R.raw.welcome);
            mp.prepareAsync();
        }catch (Exception e){e.printStackTrace();}
//        mp.start();
//        mp.setLooping(true);
    }

    public void onClick(View view) {
        Toast.makeText(this,"android.resource://"+getPackageName()+"/Music/welcome.mp3",Toast.LENGTH_LONG).show();
        if (view == start){
            mp.start();
            start.setEnabled(false);
            stop.setEnabled(true);
            pause.setEnabled(true);
            dest.setEnabled(true);
        }
        if (view == pause){
            if (mp.isPlaying()){
                mp.pause();
                pause.setText("繼續播放");
            }else{
                mp.start();
                pause.setText("暫停播放");
            }
        }
        if (view == stop){
            mp.stop();
            start.setEnabled(true);
            stop.setEnabled(false);
            pause.setEnabled(false);
            dest.setEnabled(false);
        }
        if (view == dest){
            mp.stop();
            mp.release();
            start.setEnabled(false);
            stop.setEnabled(false);
            pause.setEnabled(false);
            dest.setEnabled(false);
        }
    }

    protected void onResume() {
        super.onResume();
        mp.start();
    }

    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }

    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    public void onCompletion(MediaPlayer mp) {
        mp.seekTo(0);
        start.setEnabled(true);
        stop.setEnabled(false);
        pause.setEnabled(false);
        dest.setEnabled(false);
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        Toast.makeText(this,"發生錯誤中止播放",Toast.LENGTH_SHORT).show();
        return true;
    }

    public void onPrepared(MediaPlayer mp) {
        start.setEnabled(true);
        stop.setEnabled(false);
        pause.setEnabled(false);
        dest.setEnabled(false);
    }
}