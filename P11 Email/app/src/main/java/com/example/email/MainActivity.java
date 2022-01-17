package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,subject, msg;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.editText1);
        subject = findViewById(R.id.editText2);
        msg = findViewById(R.id.editText3);

        send = findViewById(R.id.button);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!email.getText().toString().isEmpty()) {
                    String to = email.getText().toString();
                    String sub = subject.getText().toString();
                    String message = msg.getText().toString();

                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                    email.putExtra(Intent.EXTRA_SUBJECT, sub);
                    email.putExtra(Intent.EXTRA_TEXT, message);

                    email.setType("Message/rfc822");

                    startActivity(Intent.createChooser(email, "Choose an Email client: "));
                }
                else {
                    Toast.makeText(MainActivity.this, "Please fill the Email", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}