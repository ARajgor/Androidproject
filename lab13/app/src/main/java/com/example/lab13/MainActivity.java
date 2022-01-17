package com.example.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity extends Activity {
    ImageButton start, pause, stop;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.button1);
        pause = findViewById(R.id.button2);
        stop = findViewById(R.id.button3);
    }
    public void play(View v) {
        if (mp == null) {
            mp = MediaPlayer.create(this, R.raw.m1);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (mp!=null){
                        mp.release();
                        mp=null;}
                }
            });
        }
        mp.start();
    }
    public void pause(View v) {
        if (mp != null) {
            mp.pause();
        }
    }
    public void stop(View v) {
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }
}