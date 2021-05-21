package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UW2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_w2);
        Button b1=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                finish();
            }

        });
    }
}