package com.example.imeppac;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
public class Redes extends AppCompatActivity{
    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redes);
        ImageButton face=findViewById(R.id.btnFace),
                whats= findViewById(R.id.btnWhats),
                isnta=findViewById(R.id.btnInsta),
                gmail=findViewById(R.id.btngmail);
        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/imepp.ac")));
            }
        });
        isnta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.instagram.com/imepp/")));
            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW , Uri.parse("mailto"+"imeppac@gmail.com"));
           intent.putExtra(Intent.EXTRA_SUBJECT,"Contactanos");
           intent.putExtra(Intent.EXTRA_TEXT,"Redes");
            }
        });
        btn=findViewById(R.id.regresar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Redes.this,menu_about.class);
                startActivity(intent);
            }
        });
        whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://api.whatsapp.com/send?phone=+524499930807")));
            }
        });
    }

}
