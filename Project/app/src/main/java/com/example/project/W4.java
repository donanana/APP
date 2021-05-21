package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class W4 extends AppCompatActivity implements View.OnClickListener{

    Button b4,b5,b6,b7,b8,b9;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w4);
        b4=(Button)findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5=(Button)findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6=(Button)findViewById(R.id.b6);
        b6.setOnClickListener(this);
        b7=(Button)findViewById(R.id.b7);
        b7.setOnClickListener(this);
        b8=(Button)findViewById(R.id.b8);
        b8.setOnClickListener(this);
        b9=(Button)findViewById(R.id.b9);
        b9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent it=new Intent();
        it.setAction(Intent.ACTION_VIEW);
        if(b4==view) it.setData(Uri.parse("tel:0912345678"));
        if(b5==view) it.setData(Uri.parse("http://www.csie.tku.edu.tw"));
        if(b6==view) it.setData(Uri.parse("sms:0912345678?body=hello"));
        if(b7==view) it.setData(Uri.parse("geo:25.0511063,121.5188172"));
        if(b8==view){
            it.setAction(Intent.ACTION_WEB_SEARCH);
            it.putExtra(SearchManager.QUERY,"小米手環");
        }
        if(b9==view){
            it.setData(Uri.parse("mailto:104260@mail.tku.edu.tw"));
            it.putExtra(Intent.EXTRA_CC,new String[]{"077121@mail.edu.tw","077120@mail.edu.tw","077122@mail.edu.tw"});
            it.putExtra(Intent.EXTRA_SUBJECT,"詢問寄信");
            it.putExtra(Intent.EXTRA_TEXT,"有收到信嗎");
        }
        startActivity(Intent.createChooser(it,"請選擇瀏覽器"));
    }
}