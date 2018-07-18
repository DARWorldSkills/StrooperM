package com.aprendiz.ragp.strooperm.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aprendiz.ragp.strooperm.R;
import com.aprendiz.ragp.strooperm.models.GestorDB;
import com.aprendiz.ragp.strooperm.models.Score;

import java.util.List;

public class Puntuacion extends AppCompatActivity {
    //Declaración de los campos de la actividad Puntuación
    TextView txtPrimero, txtSegundo, txtTercero, txtCuarto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);
        inizialite();
        inputData();
    }


    //Inizialización de los campos txtPrimero, txtSegundo, txtTercero y txtCuarto
    private void inizialite() {
        txtPrimero = findViewById(R.id.txtPrimero);
        txtSegundo = findViewById(R.id.txtSegundo);
        txtTercero = findViewById(R.id.txtTercero);
        txtCuarto = findViewById(R.id.txtCuarto);

    }

    //Método para el ingreso de text en los campos txtPrimero, txtSegundo, txtTercero y txtCuarto
    private void inputData() {
        GestorDB gestorDB = new GestorDB(this);
        //Llamado la la función de listScore de la clase GestorDB
        List<Score> scoreList = gestorDB.listScore();
        if (scoreList.size()>0){
            txtPrimero.setText(scoreList.get(0).getPuntuacion()+"%");
        }

        if (scoreList.size()>1){
            txtSegundo.setText(scoreList.get(1).getPuntuacion()+"%");
        }

        if (scoreList.size()>2){
            txtTercero.setText(scoreList.get(2).getPuntuacion()+"%");
        }

        if (scoreList.size()>3){
            txtCuarto.setText(scoreList.get(3).getPuntuacion()+"%");
        }


    }

    public void salir(View view) {
        finish();
    }
}
