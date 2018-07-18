package com.aprendiz.ragp.strooperm.controllers;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aprendiz.ragp.strooperm.R;

public class MenuJ extends AppCompatActivity  {
    //Declaración de vistas de la actividad MenuJ
    Button btnJugar, btnPuntuacion, btnConfiguracion;
    public static int guardar=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_j);

    }

    //




    public void a(View view) {

        Intent  intent = new Intent(MenuJ.this, Juego.class);
        guardar=1;
        startActivity(intent);

    }

    public void b(View view) {
        Intent intent = new Intent(MenuJ.this, Puntuacion.class);
        guardar=0;
        startActivity(intent);

    }

    public void c(View view) {


        Intent intent = new Intent(MenuJ.this, Configuracion.class);
        startActivity(intent);
        guardar=0;
    }
}

