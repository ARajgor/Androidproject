package com.example.lab14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t;
    TextInputLayout text1;
    MaterialButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=findViewById(R.id.text1);
        b1=findViewById(R.id.b1);
        t=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    t.setLanguage(Locale.UK);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),text1.getEditText().getText().toString(),Toast.LENGTH_SHORT).show();
                t.speak(text1.getEditText().getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
    public void onPause(){
        if(t!=null){
            t.stop();
            t.shutdown();
        }
        super.onPause();
    }
}