package com.aprendiz.ragp.strooperm.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.aprendiz.ragp.strooperm.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Declaración del timerTask para el Splash
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,MenuJ.class);
                startActivity(intent);
                finish();
            }
        };

        //Declaración del timer para el Splash
        Timer timer = new Timer();
        timer.schedule(timerTask, 1800);
    }
}
