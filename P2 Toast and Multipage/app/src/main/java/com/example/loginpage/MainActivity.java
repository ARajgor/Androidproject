package com.example.loginpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.t1);
        e2=findViewById(R.id.t2);
        b=findViewById(R.id.b);
        builder = new AlertDialog.Builder(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().equals("admin") &&
                        e2.getText().toString().equals("admin")){
                    builder.setMessage("Login Successful").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) { finish();
                        }
                    });
                }else {
                    builder.setMessage("Wrong Credentials").setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {  finish();
                        }
                    });
                }
                AlertDialog alert = builder.create();
                alert.setTitle("Login");
                alert.show();
            }
        });
    }
}