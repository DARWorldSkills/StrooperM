package com.aprendiz.ragp.strooperm.controllers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.aprendiz.ragp.strooperm.R;

public class Configuracion extends AppCompatActivity {
    RadioButton rbtnTiempo, rbtnIntentos;
    EditText txttiempo;
    Button salir;
    SharedPreferences juegoc;
    int modo, tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        juegoc = getSharedPreferences("juegoC",MODE_PRIVATE);
        inizialite();
        inputData();


    }

    //Método para cargar los valores preferenciales
    private void inputData() {
        modo= juegoc.getInt("modo",1);
        if (modo==1){
            rbtnTiempo.setChecked(true);
        }

        if (modo==2){
            rbtnIntentos.setChecked(true);
        }

        tiempo = juegoc.getInt("tiempo",3);

        txttiempo.setText(Integer.toString(tiempo));

    }


    //Método para inizializar las vista de la activodad de configuración
    private void inizialite() {
        rbtnIntentos = findViewById(R.id.rbtnIntentos);
        rbtnTiempo = findViewById(R.id.rbtnTiempo);
        txttiempo= findViewById(R.id.txtTiempoC);

    }


    public void confi(View view) {

        String tmp = txttiempo.getText().toString();
        SharedPreferences.Editor editor = juegoc.edit();
        if (tmp.length()>0){
            try {
                if (Integer.parseInt(tmp)<11 && Integer.parseInt(tmp)>0) {
                    editor.putInt("tiempo", Integer.parseInt(tmp));
                }else {
                    Toast.makeText(Configuracion.this, "No se guardará el tiempo de la palabra." +
                            " \n Por favor que este sea menor a 11 y mayor a 1", Toast.LENGTH_SHORT).show();
                }

            }catch (Exception e){
                Toast.makeText(Configuracion.this, "Por favor ingrese solo número", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(Configuracion.this, "No se guardará el tiempo de la palabra." +
                    " \n Por favor que este sea menor a 11 y mayor a 1", Toast.LENGTH_SHORT).show();
        }

        if (rbtnTiempo.isChecked()){
            editor.putInt("modo",1);
        }

        if (rbtnIntentos.isChecked()){
            editor.putInt("modo",2);

        }

        editor.commit();

        Intent intent = new Intent(Configuracion.this, JuegoC.class );
        startActivity(intent);
        finish();


    }
}


