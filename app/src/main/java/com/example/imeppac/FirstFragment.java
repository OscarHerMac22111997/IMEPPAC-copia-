package com.example.imeppac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);
        Button juegos, Actividades,Curiosidades,Sobre;
                juegos =findViewById(R.id.button_game);
                Actividades= findViewById(R.id.button_activity);
                Curiosidades=findViewById(R.id.button_curiosity);
                Sobre=findViewById(R.id.button_about);

        juegos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FirstFragment.this, menu_games.class);
                startActivity(intent1);            }
        });
        Actividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FirstFragment.this, Actividades.class);
                startActivity(intent1);
            }
        });

        Curiosidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FirstFragment.this,Curiosidades .class);
                startActivity(intent1);
            }
        });


        Sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FirstFragment.this, menu_about.class);
                startActivity(intent1);            }
        });
    }

}
