package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UW5 extends AppCompatActivity implements View.OnClickListener {

    LinearLayout ll;
    EditText ex,us,nt,ex2,us2,nt2;
    Button b1,b2,b3,b4,b5,b6,b7,b8;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w5);
        ll=(LinearLayout)findViewById(R.id.L1);

        TextView t1=new TextView(this);
        t1.setText("姓名：小明");
        t1.setTextSize(25);

        TextView t2=new TextView(this);
        t2.setAutoLinkMask(Linkify.PHONE_NUMBERS);
        t2.setText("電話:0971791773");
        t2.setTextSize(25);

        TextView t3=new TextView(this);
        t3.setAutoLinkMask(Linkify.EMAIL_ADDRESSES);
        t3.setText("EMAIL:dona@gms.edu.tku.tw");
        t3.setTextSize(25);

        TextView t4=new TextView(this);
        t4.setAutoLinkMask(Linkify.WEB_URLS);
        t4.setText("URL:http://tw.yahoo.com");
        t4.setTextSize(25);

        ll.addView(t1);
        ll.addView(t2);
        ll.addView(t3);
        ll.addView(t4);

        nt=(EditText)findViewById(R.id.ntd);
        us=(EditText)findViewById(R.id.usd);
        ex=(EditText)findViewById(R.id.exg);
        nt2=(EditText)findViewById(R.id.ntd2);
        us2=(EditText)findViewById(R.id.usd2);
        ex2=(EditText)findViewById(R.id.exg2);

        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.button5);
        b6=(Button) findViewById(R.id.button6);
        b7=(Button) findViewById(R.id.button7);
        b8=(Button) findViewById(R.id.button8);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
    }
    public void onClick(View view){
        if(view == b4 || view == b8)finish();

        if(view == b3 || view == b7){
            ex.setText("");
            nt.setText("");
            us.setText("");
            ex2.setText("");
            nt2.setText("");
            us2.setText("");
        }

        if(view == b1){
            String e=ex.getText().toString(),
                    n=nt.getText().toString();
            if(e.length()==0||n.length()==0)
                Toast.makeText(this, "有必要欄位沒有輸入", Toast.LENGTH_SHORT).show();
            else{
                double exx=Double.parseDouble(e),ntt=Double.parseDouble(n),uu=ntt/exx;
                String ff=String.format("%.2f",uu);
                us.setText(ff);
            }
        }

        if(view == b5){
            String e=ex2.getText().toString(),
                    n=nt2.getText().toString();
            if(e.length()==0||n.length()==0)
                Toast.makeText(this, "有必要欄位沒有輸入", Toast.LENGTH_SHORT).show();
            else{
                double exx=Double.parseDouble(e),ntt=Double.parseDouble(n),uu=ntt/exx;
                String ff=String.format("%.2f",uu);
                us2.setText(ff);
            }
        }

        if(view == b2){
            String e=ex.getText().toString(),
                    u=us.getText().toString();
            if(e.length()==0||u.length()==0)
                Toast.makeText(this, "有必要欄位沒有輸入", Toast.LENGTH_SHORT).show();
            else{
                double exx=Double.parseDouble(e),uu=Double.parseDouble(u),ntt=uu*exx;
                String ff=String.format("%.2f",ntt);
                nt.setText(ff);
            }
        }
        if(view == b6){
            String e=ex2.getText().toString(),
                    u=us2.getText().toString();
            if(e.length()==0||u.length()==0)
                Toast.makeText(this, "有必要欄位沒有輸入", Toast.LENGTH_SHORT).show();
            else{
                double exx=Double.parseDouble(e),uu=Double.parseDouble(u),ntt=uu*exx;
                String ff=String.format("%.2f",ntt);
                nt2.setText(ff);
            }
        }

    }
}