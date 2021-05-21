package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class W8 extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    TextView t1,t2;
    Button b1;
    EditText ed1,ed2,sel;
    String cop="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w8);
        t1=(TextView)findViewById(R.id.tv1);
        t2=(TextView)findViewById(R.id.tv2);
        ed1=(EditText) findViewById(R.id.ed1);
        ed2=(EditText) findViewById(R.id.ed2);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        registerForContextMenu(ed1);
        registerForContextMenu(ed2);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.copy) {
            cop=sel.getText().toString();
            t1.setText("copy-->"+cop);
        }
        else {
            sel.setText(cop);
            t1.setText("paste-->"+cop);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context,menu);
        sel=(EditText)v;
        super.onCreateContextMenu(menu,v,menuInfo);
    }

    @Override
    public void onClick(View view) {
        PopupMenu pop= new PopupMenu(this,b1);
        pop.getMenuInflater().inflate(R.menu.popupmenu, pop.getMenu());
        pop.show();
        pop.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        String ss=ed1.getText().toString();
        if (ss.length()>0){
            if (menuItem.getItemId() == R.id.one) t1.setText(ss);
            if (menuItem.getItemId() == R.id.two) t2.setText(ss);
            if (menuItem.getItemId() == R.id.cls) {
                t1.setText("");
                t2.setText("");
                ed1.setText("");
            }
        }
        return false;
    }
}