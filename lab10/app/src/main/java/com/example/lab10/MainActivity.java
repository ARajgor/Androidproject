package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText pn, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        pn = findViewById(R.id.pn);
        msg = findViewById(R.id.msg);
        int a = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == PackageManager.PERMISSION_GRANTED) {
                    String no = pn.getText().toString().trim();
                    String msgs = msg.getText().toString().trim();
                    if (!pn.getText().toString().equals("") && !msg.getText().toString().equals("")) {
                        SmsManager s = SmsManager.getDefault();
                        s.sendTextMessage(no, null, msgs, null, null);
                        Toast.makeText(getApplicationContext(), "Message Sent....", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Please enter Mobile number and Message", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 0);
                }
            }
        });
    }
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String no = pn.getText().toString().trim();
                    String msgs = msg.getText().toString().trim();
                    SmsManager s = SmsManager.getDefault();
                    s.sendTextMessage(no, null, msgs, null, null);
                    Toast.makeText(getApplicationContext(), "Message Sent....", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
}