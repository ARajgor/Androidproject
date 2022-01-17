package com.example.lab7;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    ImageButton GOsb3,GOcal3;
    Button b2;
    TextView tv2;
    TimePicker tp;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        GOsb3=findViewById(R.id.GOsb3);
        GOcal3=findViewById(R.id.GOcal3);
        b2=findViewById(R.id.b2);
        tv2=findViewById(R.id.tv2);
        tp=findViewById(R.id.tp);
        tp.setIs24HourView(true);
        tv2.setText(getCurrenttime());

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(getCurrenttime());
            }
        });

        GOcal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Calendar",Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(i3);
            }
        });
        GOsb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Seekbar",Toast.LENGTH_SHORT).show();
                Intent j3 = new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(j3);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public String getCurrenttime() {
        String currenttime="Current Time: "+tp.getHour()+":"+tp.getMinute();
        return currenttime;
    }
}