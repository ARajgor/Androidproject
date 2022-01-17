package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageButton GOsb1,GOclock1;
    Button b1;
    TextView tv1;
    DatePicker Dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GOsb1=findViewById(R.id.GOsb1);
        GOclock1=findViewById(R.id.GOclock1);
        b1=findViewById(R.id.b1);
        tv1=findViewById(R.id.tv1);
        Dp=findViewById(R.id.Dp);
        tv1.setText("Current Date: "+ getcurrentDate());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("Change Date: "+getcurrentDate());
            }
        });

        GOsb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Seekbar",Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i1);
            }
        });
        GOclock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Clock",Toast.LENGTH_SHORT).show();
                Intent j1 = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(j1);
            }
        });
    }

    public String getcurrentDate() {
        StringBuilder builder=new StringBuilder();
        builder.append((Dp.getMonth()+1)+"/");   //month 0 thi start thay etle...
        builder.append(Dp.getDayOfMonth()+"/");
        builder.append(Dp.getYear());
        return builder.toString();
    }
}