package com.aprendiz.ragp.strooperm.controllers;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aprendiz.ragp.strooperm.R;

public class MenuJ extends AppCompatActivity implements View.OnClickListener {
    //Declaración de vistas de la actividad MenuJ
    Button btnJugar, btnPuntuacion, btnConfiguracion;
    public static int guardar=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_j);
        inizialite();
    }

    //Inicialización de las vistas de la actividad MenuJ
    private void inizialite() {
        btnJugar = findViewById(R.id.btnJugar);
        btnPuntuacion = findViewById(R.id.btnPuntuacion);
        btnConfiguracion = findViewById(R.id.btnConfiguracion);

        //Ingreso de evento onClick a los botones anteriormente inicializados
        btnJugar.setOnClickListener(this);
        btnPuntuacion.setOnClickListener(this);
        btnConfiguracion.setOnClickListener(this);
    }

    //Evento onClick para los botones de la actividad MenuJ
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnJugar:
                intent = new Intent(MenuJ.this, Juego.class);
                guardar=1;
                startActivity(intent);
                break;

            case R.id.btnPuntuacion:
                intent = new Intent(MenuJ.this, Puntuacion.class);
                guardar=1;
                break;

            case R.id.btnConfiguracion:
                intent = new Intent(MenuJ.this, Configuration.class);
                guardar=1;
                break;
        }
    }
}
