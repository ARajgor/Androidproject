package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ProgressBar P1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        P1 = findViewById(R.id.progressBar1);

        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"progressBarStyleHorizontal",Toast.LENGTH_SHORT).show();
                Thread t = new Thread()
                {
                    @Override
                    public void run() {
                        super.run();
                        for (int i=0 ;i<=100;)
                        {
                            try {
                                sleep(500);
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            P1.setProgress(i);
                            i=i+10;
                        }
                    }
                };
                t.start();
            }
        });


    }
}