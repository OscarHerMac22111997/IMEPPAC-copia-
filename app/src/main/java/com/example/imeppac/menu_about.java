package com.example.imeppac;
import androidx.appcompat.app.AppCompatActivity;


import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
public class menu_about  extends AppCompatActivity{



@Override
 protected void onCreate (Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.about);
    Button Redes, btnOrigen, btnUbicacion;
    Redes = findViewById(R.id.redes);
    btnOrigen = findViewById(R.id.origen);
    btnUbicacion = findViewById(R.id.Ubicacion);

    Redes.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(menu_about.this, Redes.class);
            startActivity(intent1);
        }
    });


    btnOrigen.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent1 = new Intent(menu_about.this, Origen.class);
            startActivity(intent1);
                                     }});
btnUbicacion.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent1=new Intent(menu_about.this,MapsActivity.class );
        startActivity(intent1);
    }});
    }}
