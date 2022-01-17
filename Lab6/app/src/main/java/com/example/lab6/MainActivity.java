package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    ImageButton I;
    ToggleButton T;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        I = findViewById(R.id.imageButton);
        T = findViewById(R.id.toggleButton);
    }

    //image button
    public void onClickIB(View view) {
        Intent i=new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);

        Toast.makeText(this,"You click image button.",Toast.LENGTH_LONG).show();
    }

    //Toggle button
    public void onClickTB(View view) {
        if(T.isChecked()){
            // 1st Activity background color change(Dark mode)
            RelativeLayout B1 =(RelativeLayout) findViewById(R.id.Activity_1);
            B1.setBackgroundColor(Color.BLACK);

            // For Activity 1st Text
            t1 =findViewById(R.id.Text_DR); // For dark mode Text
            t2 =findViewById(R.id.Text_PR); // For progressbar Text

            t1.setTextColor(getResources().getColor(R.color.white));  // change Text(Dark mode) color
            t2.setTextColor(getResources().getColor(R.color.white));  // change Text(progressbar) color


        }
        else {
            // 1st Activity background color change(normal mode)
            RelativeLayout B1 = (RelativeLayout) findViewById(R.id.Activity_1);
            B1.setBackgroundColor(Color.WHITE);

            // For Activity 1st Text
            t1.setTextColor(getResources().getColor(R.color.black));  // change Text(Dark mode) color
            t2.setTextColor(getResources().getColor(R.color.black));  // change Text(progressbar) color

            //For Activity 2nd Text
            // t3.setTextColor(getResources().getColor(R.color.black));  // change Text(this is progressbar) color
        }

    }
}