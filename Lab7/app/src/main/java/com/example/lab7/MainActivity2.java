package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    SeekBar seekBar;
    ImageButton GOclock2,GOcal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        GOclock2=findViewById(R.id.GOclock2);
        GOcal2=findViewById(R.id.GOcal2);
        seekBar=findViewById(R.id.seekBar);

        GOcal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Calendar",Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i2);
            }
        });
        GOclock2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Clock",Toast.LENGTH_SHORT).show();
                Intent j2 = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(j2);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(),"Seekbar Progress "+progress,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Seekbar touch started..",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Seekbar touch stoped..",Toast.LENGTH_SHORT).show();

            }
        });
    }
}