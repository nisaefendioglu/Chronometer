package com.nisaefendioglu.chronometerapp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button buton, restart,play;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void init(){
        chronometer = findViewById(R.id.chronometer);
        buton = findViewById(R.id.buton);
        buton.setBackgroundTintList(null);
        restart = findViewById(R.id.restart);
        restart.setBackgroundTintList(null);
        restart.setVisibility(View.GONE);
        play = findViewById(R.id.play);
        play.setBackgroundTintList(null);
        play.setVisibility(View.GONE);
        actions();
    }

    void actions(){
        buton.setOnClickListener(view -> {
            chronometer.start();
            buton.setBackgroundResource(R.drawable.stop);
            buton.setOnClickListener(view13 -> {
                chronometer.stop();
                buton.setBackgroundResource(R.drawable.finish);
                restart.setVisibility(View.VISIBLE);
                play.setVisibility(View.VISIBLE);
                restart.setOnClickListener(view12 -> {
                    buton.setBackgroundResource(R.drawable.start);
                    restart();
                });

                play.setOnClickListener(view1 -> {
                    buton.setBackgroundResource(R.drawable.start);
                    play();
                });
            });
        });
    }

    void restart (){
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.stop();
        actions();
    }

    void play(){
        actions();
    }

}
