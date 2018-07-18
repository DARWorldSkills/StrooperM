package com.aprendiz.ragp.strooperm.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.strooperm.R;
import com.aprendiz.ragp.strooperm.models.GestorDB;
import com.aprendiz.ragp.strooperm.models.Score;

public class Resumen extends AppCompatActivity {
    TextView txtCorrectas, txtIncorrectas, txtAciertos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        inizialite();
        inputData();
    }


    private void inizialite() {
        txtCorrectas = findViewById(R.id.txtCorrectasR);
        txtIncorrectas = findViewById(R.id.txtIncorrectasR);
        txtAciertos = findViewById(R.id.txtAciertosR);
    }


    //Método ingreso de los resultados en los campos txtCorrectas, txtIncorrectas y txtAciertos
    private void inputData() {
        if (MenuJ.guardar==1){
            txtCorrectas.setText(Integer.toString(Juego.correctas));
            txtIncorrectas.setText(Integer.toString(Juego.incorrectas));
            txtAciertos.setText(Integer.toString(Juego.aciertos));
            inputInDataBase();

        }else {
            txtCorrectas.setText(Integer.toString(JuegoC.correctas));
            txtIncorrectas.setText(Integer.toString(JuegoC.incorrectas));
            txtAciertos.setText(Integer.toString(JuegoC.aciertos));
        }

    }

    //Método para el llamado del método inputData de la Clase GestorDB
    private void inputInDataBase() {
        Score score = new Score();
        score.setPuntuacion(Integer.toString(Juego.intentos));
        score.setIncorrectas(Integer.toString(Juego.incorrectas));
        GestorDB gestorDB = new GestorDB(this);
        gestorDB.inputData(score);

    }
}
