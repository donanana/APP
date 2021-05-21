package com.example.project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Date;

public class W6 extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {

        String a[]={"1.按一下編輯","2.長按清除項目","3.","4.","5.","6."};
        ListView lv;ArrayAdapter<String> am;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w6);
        lv=(ListView)findViewById(R.id.lv);
        am=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a);
        lv.setAdapter(am);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent it=new Intent(this,W6_2.class);
        it.putExtra("內容",a[i]);
        startActivityForResult(it,i);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            a[requestCode] = data.getStringExtra("內容");
            am.notifyDataSetChanged();
            Time t=new Time(System.currentTimeMillis());
//            int yy=t.getYear(),mon=t.getMonth()+1,da=t.getDay();
            Date d=new Date();int yy=d.getYear()-100+2000,mon=d.getMonth()+1,da=d.getDate();
            int hh=t.getHours(),mm=t.getMinutes()+1,ss=t.getSeconds();
            Toast.makeText(this,"備忘項目第"+(requestCode+1)+"項\n已於"
                    +yy+"/"+mon+"/"+da+"/"+hh+":"+mm+":"+ss+"被修改",Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        a[i]=(i+1)+".";
        am.notifyDataSetChanged();
        return true;
    }
}