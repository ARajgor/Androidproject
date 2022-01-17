package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar rb;
    TextView tv;
    Switch s;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb=findViewById(R.id.ratingBar);
        tv=findViewById(R.id.textView);
        s=findViewById(R.id.switch1);
        b=findViewById(R.id.button);

        s.setChecked(true);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv.setText("Swich is ON");
                    Toast.makeText(getApplicationContext(),"Swich is ON",Toast.LENGTH_SHORT).show();
                }
                else{
                    tv.setText("Swich is OFF");
                    Toast.makeText(getApplicationContext(),"Swich is OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
        if(s.isChecked()){
            tv.setText("Swich is ON");
            Toast.makeText(getApplicationContext(),"Swich is ON",Toast.LENGTH_SHORT).show();
        }
        else{
            tv.setText("Swich is OFF");
            Toast.makeText(getApplicationContext(),"Swich is OFF",Toast.LENGTH_SHORT).show();
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Rate is: "+String.valueOf(rb.getRating()),Toast.LENGTH_SHORT).show();
            }
        });
    }
}