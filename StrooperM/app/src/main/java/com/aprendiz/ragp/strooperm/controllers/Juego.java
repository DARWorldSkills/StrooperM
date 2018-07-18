package com.aprendiz.ragp.strooperm.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.strooperm.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego extends AppCompatActivity implements View.OnClickListener{
    //Declaración de variables
    List<String> listapalabra = new ArrayList<>();
    List<Integer> listaColores = new ArrayList<>();
    TextView txtcorrectas, txtincorrectas, txtaciertos, txtintentos, txttiempo, txtpalabra;
    Button btnColor1, btnColor2, btnColor3, btnColor4;
    List<Integer> listaColorestmp = new ArrayList<>();
    public static int correctas, incorrectas, aciertos, intentos;
    int [] segundos = {0, 30};
    boolean bandera = true;
    int ab = 0, ipR, icR, valorcito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        ab=0;
        correctas=0;
        incorrectas=0;
        aciertos=0;
        intentos=0;
        segundos[0]=0;
        segundos[1]=30;



        inizialite();
        listTODO();
        randomA();
        inputData();

        go_game();
        txttiempo.setText("Tiempo: "+segundos[1]);
    }
    //Método para iniciar el timepo del juego
    private void go_game() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (bandera){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            segundos[0]++;
                            segundos[1]--;

                            if (segundos[0]==3){
                                incorrectas++;
                                intentos++;
                                inputData();
                                randomA();

                                segundos[0]=0;
                            }

                            txttiempo.setText("Tiempo: "+ segundos[1]);

                            end_game();

                        }
                    });

                }
            }
        });
        thread.start();
    }


    //Método para salir del juego
    private void end_game() {
        if (ab==0 && (segundos[1]==0 || incorrectas==3)){
            ab=1;
            Intent intent = new Intent(Juego.this,Resumen.class);
            startActivity(intent);
            bandera=false;
            finish();
        }
    }


    //Método para randomizar los botones e ingresar el texto random y el color random al campo txtpalabra
    private void randomA() {
        listaColorestmp = listaColores;
        Collections.shuffle(listaColorestmp);
        ipR = (int) (Math.random()*4);
        icR = (int) (Math.random()*4);
        txtpalabra.setText(listapalabra.get(ipR));
        txtpalabra.setTextColor(listaColores.get(icR));

        btnColor1.setBackgroundColor(listaColorestmp.get(0));
        btnColor2.setBackgroundColor(listaColorestmp.get(1));
        btnColor3.setBackgroundColor(listaColorestmp.get(2));
        btnColor4.setBackgroundColor(listaColorestmp.get(3));



    }

    private void listTODO() {
        listapalabra.add("AMARILLO");
        listaColores.add(getColor(R.color.colorAmarilloJ));
        listapalabra.add("AZUL");
        listaColores.add(getColor(R.color.colorAzulJ));
        listapalabra.add("ROJO");
        listaColores.add(getColor(R.color.colorRojoJ));
        listapalabra.add("VERDE");
        listaColores.add(getColor(R.color.colorVerdeJ));
    }

    //Inicialización de las vistas de la actividad Juego
    private void inizialite() {
        txtcorrectas = findViewById(R.id.txtCorrectasJ);
        txtincorrectas = findViewById(R.id.txtIncorrectasJ);
        txtaciertos = findViewById(R.id.txtAciertosJ);
        txtintentos = findViewById(R.id.txtIntentosJ);
        txttiempo = findViewById(R.id.txtTiempoJ);
        txtpalabra = findViewById(R.id.txtPalabraJ);


        btnColor1 = findViewById(R.id.btnColor1);
        btnColor2 = findViewById(R.id.btnColor2);
        btnColor3 = findViewById(R.id.btnColor3);
        btnColor4 = findViewById(R.id.btnColor4);

        //Ingreso de evento onClick a los botones anteriormente inicializados
        btnColor1.setOnClickListener(this);
        btnColor2.setOnClickListener(this);
        btnColor3.setOnClickListener(this);
        btnColor4.setOnClickListener(this);
    }


    //Método para el ingreso de texto a los campos txtcorrectas, txtincorrectas, txtaciertos y txtintentos
    private void inputData() {

        if (intentos>0){
            if (incorrectas>0){
                float tmp1= correctas, tmp2 = intentos;
                float tmpP = (tmp1/ tmp2)*100;
                aciertos= (int) tmpP;

            }else {
                aciertos=100;
            }
        }


        txtaciertos.setText("Aciertos: "+aciertos+"%");
        txtcorrectas.setText("Correctas: "+correctas);
        txtincorrectas.setText("Incorrectas: "+incorrectas);
        txtintentos.setText("Intentos: "+intentos);
    }

    private void comprobar() {
        if (valorcito==1){
            if (listaColores.get(icR)==listaColorestmp.get(0)){
                correctas++;
            }else {
                incorrectas++;
            }
        }

        if (valorcito==2){
            if (listaColores.get(icR)==listaColorestmp.get(1)){
                correctas++;
            }else {
                incorrectas++;
            }
        }

        if (valorcito==3){
            if (listaColores.get(icR)==listaColorestmp.get(2)){
                correctas++;
            }else {
                incorrectas++;
            }
        }

        if (valorcito==4){
            if (listaColores.get(icR)==listaColorestmp.get(3)){
                correctas++;
            }else {
                incorrectas++;
            }
        }

        intentos++;
        inputData();
        randomA();
        end_game();
        segundos[0]=0;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnColor1:
                valorcito=1;
                comprobar();

                break;

            case R.id.btnColor2:
                valorcito=2;
                comprobar();

                break;

            case R.id.btnColor3:
                valorcito=3;
                comprobar();

                break;

            case R.id.btnColor4:
                valorcito=4;
                comprobar();

                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        bandera=false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        bandera=false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bandera=false;
    }
}
