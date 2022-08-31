package com.example.imeppac;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
public class Origen extends AppCompatActivity {
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.origen);
        super.onCreate(savedInstanceState);
        btn=findViewById(R.id.imageButton6);
        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent(Origen.this,menu_about.class);
            startActivity(intent);
        }
    });
}
}

