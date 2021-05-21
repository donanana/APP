package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class UW17 extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener {

    String qu[]={"什麼門永遠不能關","什麼東西沒人愛吃","什麼瓜不能吃"}
            ,an[]={"球門","虧","傻瓜"};
    TextView r;
    ListView lv;
    Toast toa;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w17);
        toa=Toast.makeText(this,"",Toast.LENGTH_SHORT);
        AlertDialog.Builder ab=new AlertDialog.Builder(this);
        ab.setIcon(R.drawable.icon)
//        ab.setIcon(android.R.drawable.presence_away);
                .setTitle("歡迎")
                .setMessage("交談窗示範教學")
                .setCancelable(false)
                .setNegativeButton("不好",this)
                .setNeutralButton("沒意見",this)
                .setPositiveButton("很好",this).show();

        r=(TextView)findViewById(R.id.tv);
        lv=(ListView)findViewById(R.id.lv1);
        ArrayAdapter<String> ss=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,qu);
        lv.setAdapter(ss);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        r.setText("第"+i+"項"+"答案為："+an[i]);
        toa.setText("第"+i+"項"+"答案為："+an[i]);
        toa.show();
        toa.setGravity(Gravity.TOP|Gravity.RIGHT,50,50);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == DialogInterface.BUTTON_POSITIVE){
            toa.setText("您選了很好");
            toa.show();
        }
        if (i == DialogInterface.BUTTON_NEGATIVE){
            toa.setText("您選了不好");
            toa.show();
        }
        if (i == DialogInterface.BUTTON_NEUTRAL){
            toa.setText("您選了沒意見");
            toa.show();
        }
    }
}