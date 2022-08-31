package com.example.imeppac;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageButton;
import android.content.Intent;
public class menu_games extends AppCompatActivity {
    ImageButton btn;
    @Override
    protected void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.menu_juegos);
        Button Memorama, Planta,Rompecabezas;
        Memorama = findViewById(R.id.memorama);
        Planta = findViewById(R.id.Planta);
        btn=findViewById(R.id.imageButton5);
        Rompecabezas=findViewById(R.id.Rompecabeza);


        Memorama.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent1 = new Intent(menu_games.this, memorama.class);
                startActivity(intent1);
            }
        });


        Planta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(menu_games.this,Simulacion.class);
                startActivity(intent1);
            }            });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menu_games.this,menu_about.class);
                startActivity(intent);
            }
        });
        Rompecabezas.setOnClickListener(new View.OnClickListener(){
        @Override
     

                    public void onClick(View v){
                Intent intent= new Intent(menu_games.this,Rompecabezas.class);
            }

});}}