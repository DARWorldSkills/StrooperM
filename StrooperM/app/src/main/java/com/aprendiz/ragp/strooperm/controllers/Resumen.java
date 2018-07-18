package com.aprendiz.ragp.strooperm.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.strooperm.R;
import com.aprendiz.ragp.strooperm.models.GestorDB;
import com.aprendiz.ragp.strooperm.models.Score;

public class Resumen extends AppCompatActivity {
    TextView txtCorrectas, txtIncorrectas, txtAciertos;
    ImageButton btnTwi, btnFace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        inizialite();
        inputData();


        //Compartit en Twitter

        btnTwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "hola");
                intent.setPackage("com.twitter.android");

                try {
                    startActivity(intent);

                }catch (Exception e){
                    Toast.makeText(Resumen.this, "No cuentas con esta App, por favor instale la app", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }


            }
        });

    }


    private void inizialite() {
        txtCorrectas = findViewById(R.id.txtCorrectasR);
        txtIncorrectas = findViewById(R.id.txtIncorrectasR);
        txtAciertos = findViewById(R.id.txtAciertosR);
        btnTwi = findViewById(R.id.btnTwi);
        btnFace = findViewById(R.id.btnFace);
    }


    //Método ingreso de los resultados en los campos txtCorrectas, txtIncorrectas y txtAciertos
    private void inputData() {
        if (MenuJ.guardar==1){
            txtCorrectas.setText(Integer.toString(Juego.correctas));
            txtIncorrectas.setText(Integer.toString(Juego.incorrectas));
            txtAciertos.setText(Integer.toString(Juego.aciertos)+"%");
            inputInDataBase();

        }else {
            txtCorrectas.setText(Integer.toString(JuegoC.correctas));
            txtIncorrectas.setText(Integer.toString(JuegoC.incorrectas));
            txtAciertos.setText(Integer.toString(JuegoC.aciertos)+"%");
        }

    }

    //Método para el llamado del método inputData de la Clase GestorDB
    private void inputInDataBase() {
        Score score = new Score();
        score.setPuntuacion(Integer.toString(Juego.aciertos));
        score.setIncorrectas(Integer.toString(Juego.incorrectas));
        GestorDB gestorDB = new GestorDB(this);
        gestorDB.inputData(score);

    }


    public void salir(View view) {
        finish();
    }

}
