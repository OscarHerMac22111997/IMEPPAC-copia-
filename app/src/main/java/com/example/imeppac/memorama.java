package com.example.imeppac;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.LogRecord;

public class memorama extends Activity {
    ImageButton imb00, imb01, imb02, imb03, imb04, imb05, imb06,
            imb07, imb08, imb09, imb10, imb11, imb12,
            imb13, imb14, imb15;
    ImageButton[]tablero=new ImageButton[16];
    Button botonReinicio,botonSalir;
    TextView textoPuntuacion;
    int puntuacion;
    int aciertos;
    int []imagenes;
    int fondo;

    ArrayList<Integer>arrayDesordenado;
    ImageButton primero;
    int numeroPrimero,numeroSegUndo;
    boolean bloqueo=false;
    final Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.memorama);
        init();
    }
    private void cargaTablero(){
    imb00=findViewById(R.id.boton00);
    imb01=findViewById(R.id.boton01);
    imb02=findViewById(R.id.boton02);
    imb03=findViewById(R.id.boton03);
    imb04=findViewById(R.id.boton04);
    imb05=findViewById(R.id.boton05);
    imb06=findViewById(R.id.boton06);
    imb07=findViewById(R.id.boton07);
    imb08=findViewById(R.id.boton08);
    imb09=findViewById(R.id.boton09);
    imb10=findViewById(R.id.boton10);
    imb11=findViewById(R.id.boton11);
    imb12=findViewById(R.id.boton12);
    imb13=findViewById(R.id.boton13);
    imb14=findViewById(R.id.boton14);
    imb15=findViewById(R.id.boton15);

    tablero[0] =imb00;
    tablero[1] =imb01;
    tablero[2] =imb02;
    tablero[3] =imb03;
    tablero[4] =imb04;
    tablero[5] =imb05;
    tablero[6] =imb06;
    tablero[7] =imb07;
    tablero[8] =imb08;
    tablero[9] =imb09;
    tablero[10] =imb10;
    tablero[11] =imb11;
    tablero[12] =imb12;
    tablero[13] =imb13;
    tablero[14] =imb14;
    tablero[15] =imb15;
    }

    private void cargarBotones(){
        botonReinicio=findViewById(R.id.Iniciar);
        botonSalir=findViewById(R.id.Salir);
        botonReinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {getIntent();

            }
        });

botonSalir.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {finish();


    }
});
        }
        private void cargaTexto() {
            textoPuntuacion = findViewById(R.id.texto_puntuacion);
            puntuacion = 0;
            aciertos = 0;
            textoPuntuacion.setText("Puntuacion: " + puntuacion);
        }
        private void cargaImagenes(){
        imagenes=new int[]{
                R.drawable.bonsai,
                R.drawable.cactus,
                R.drawable.girasol,
                R.drawable.helecho,
                R.drawable.nochebuena,
                R.drawable.pino,
                R.drawable.plantacasa,
                R.drawable.savila};
        fondo=R.drawable.imepp;
    }
private ArrayList<Integer>barajar(int longitud){
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0; i<longitud*2;i++){
            result.add(i%longitud);
        }
    Collections.shuffle(result);
        return result;
    }
    private void comprobar(int i,final ImageButton imgb){
        if (primero==null) {
            primero = imgb;
            primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
            primero.setImageResource(imagenes[arrayDesordenado.get(i)]);
            primero.setEnabled(false);
            numeroPrimero = arrayDesordenado.get(i);
        }
        else {
            bloqueo = true;
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageResource(imagenes[arrayDesordenado.get(i)]);
            imgb.setEnabled(false);
            if (numeroSegUndo == numeroSegUndo) {
                primero=null;
                bloqueo=false;
                aciertos++;
                puntuacion++;
                textoPuntuacion.setText("Puntuacion: "+puntuacion);
                Toast toast = Toast.makeText(getApplicationContext(), "Ganaste", Toast.LENGTH_SHORT);
                toast.show();
            }
        else{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    primero.setImageResource(fondo);
                    primero.setEnabled(true);
                    imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imgb.setImageResource(fondo);
                    imgb.setEnabled(true);
                    bloqueo = false;
                    primero = null;
                    puntuacion--;
                    textoPuntuacion.setText("Puntuacion:" + puntuacion);
                }
            },1000);
                }
            }

        }
        private void init() {
            cargaTablero();
            cargarBotones();
            cargaTexto();
            cargaImagenes();
            arrayDesordenado = barajar(imagenes.length);
            for (int i = 0; i < tablero.length; i++) {
                tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                tablero[i].setImageResource(imagenes[arrayDesordenado.get(i)]);

            }
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < tablero.length; i++) {
                        tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                        tablero[i].setImageResource(fondo);
                    }
                }
            }, 2000);
            for (int i = 0; i < tablero.length; i++) {
                final int j = i;
                tablero[i].setEnabled(true);
                tablero[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (bloqueo)
                            comprobar(j, tablero[j]);
                    }
                });
            }
        }}



