package com.aprendiz.ragp.strooperm.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GestorDB extends SQLiteOpenHelper {
    //Constructor para la creación de base de datos
    public GestorDB(Context context) {
        super(context,"datos.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creación de la tabla SCORE
        db.execSQL("CREATE TABLE SCORE (PUNTUACION TEXT, INCORRECTAS TEXT);");
    }

    //Método para el ingreso de valores a la tabla Score
    public void inputData(Score score){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("PUNTUACION",score.getPuntuacion());
        values.put("INCORRECTAS",score.getIncorrectas());
        db.insert("SCORE",null,values);
        db.close();
    }

    //Método para el listado ordenado de los resultados de los juegos normales finializados
    public List<Score> listScore(){
        List<Score> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SCORE ORDER BY PUNTUACION DESC AND INCORRECTAS DESC;",null);
        if (cursor.moveToFirst()){
            do {
                Score score = new Score();
                score.setPuntuacion(cursor.getString(0));
                score.setIncorrectas(cursor.getString(1));
                results.add(score);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return results;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
