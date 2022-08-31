package com.example.imeppac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menu_main extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.about);
        Button Menuprincipal, Juegos,organizacion;
        Menuprincipal = findViewById(R.id.primer_menu);
        Juegos = findViewById(R.id.juegos);
        organizacion = findViewById(R.id.organizacion);

        Menuprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(menu_main.this, FirstFragment.class);
                startActivity(intent1);
            }
        });


        Juegos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(menu_main.this, menu_games.class);
                startActivity(intent1);
            }});
        organizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(menu_main.this,menu_about.class );
                startActivity(intent1);
            }});
    }}