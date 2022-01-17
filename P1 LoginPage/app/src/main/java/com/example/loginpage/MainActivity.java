package com.example.loginpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.t1);
        e2=findViewById(R.id.t2);
        b=findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().equals("admin") &&
                        e2.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();

                    Intent i1 = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i1);

                }else {Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show(); }

            }
        });
    }
}