package com.example.root.radio;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onclick();
    }

    private void onclick() {

        Button play = (Button) findViewById(R.id.button);
        Button pause = (Button) findViewById(R.id.button2);
        String url = "http://192.168.0.160:8000/;";

        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaPlayer.prepareAsync(); // might take long! (for buffering, etc)
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }
        });
    }













    }

