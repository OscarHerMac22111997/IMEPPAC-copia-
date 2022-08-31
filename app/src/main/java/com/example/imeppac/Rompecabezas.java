package com.example.imeppac;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class  Rompecabezas extends AppCompatActivity {
    private static final int Columnas = 6;
    private static final int Dimensiones = Columnas * Columnas;

    private static String[] tileList;
    private static GestureDetectGridView mGridView;
    private static int mColumnWidth,mColumnHeight;
    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rompecabezas);
        init();
        scramble();
        setDimensions();
    }
    private void setDimensions(){
        ViewTreeObserver vto=mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth=mGridView.getMeasuredWidth();
                int displayHeight=mGridView.getMeasuredHeight();

                int statusbarHeight=getStatusBarHeight(getApplicationContext());
                int requeridHeight=displayHeight-statusbarHeight;
                 mColumnWidth=displayWidth/Columnas;
                 mColumnHeight=requeridHeight/Columnas;

                display(getApplicationContext());
            }
        });
    }
private int getStatusBarHeight(Context context) {
    int result = 0;
    int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
            "android");
    if (resourceId > 0) {
        result = context.getResources().getDimensionPixelSize(resourceId);
    }
    return result;
}

private static void display(Context context){
    ArrayList<Button>buttons=new ArrayList<>();
    Button button;
    for (int i=0; i<tileList.length;i++){
        button=new Button(context);
        if(tileList[i].equals("35"))
            button.setBackgroundResource(R.drawable.uno);
        if(tileList[i].equals("34"))
            button.setBackgroundResource(R.drawable.dos);
        if(tileList[i].equals("33"))
            button.setBackgroundResource(R.drawable.tres);
        if(tileList[i].equals("32"))
            button.setBackgroundResource(R.drawable.cuatro);
        if(tileList[i].equals("31"))
            button.setBackgroundResource(R.drawable.cinco);
        if(tileList[i].equals("30"))
            button.setBackgroundResource(R.drawable.seis);
        if(tileList[i].equals("29"))
            button.setBackgroundResource(R.drawable.siete);
        if(tileList[i].equals("28"))
            button.setBackgroundResource(R.drawable.ocho);
        if(tileList[i].equals("27"))
            button.setBackgroundResource(R.drawable.nueve);
        if(tileList[i].equals("26"))
            button.setBackgroundResource(R.drawable.diez);
        if(tileList[i].equals("25"))
            button.setBackgroundResource(R.drawable.once);
        if(tileList[i].equals("24"))
            button.setBackgroundResource(R.drawable.doce);
        if(tileList[i].equals("23"))
            button.setBackgroundResource(R.drawable.trece);
        if(tileList[i].equals("22"))
            button.setBackgroundResource(R.drawable.catorce);
        if(tileList[i].equals("21"))
            button.setBackgroundResource(R.drawable.quince);
        if(tileList[i].equals("20"))
            button.setBackgroundResource(R.drawable.dieciseis);
        if(tileList[i].equals("19"))
            button.setBackgroundResource(R.drawable.diecisiete);
        if(tileList[i].equals("18"))
            button.setBackgroundResource(R.drawable.dieciocho);
        if(tileList[i].equals("17"))
            button.setBackgroundResource(R.drawable.diecinueve);
        if(tileList[i].equals("16"))
            button.setBackgroundResource(R.drawable.veinte);
        if(tileList[i].equals("15"))
            button.setBackgroundResource(R.drawable.veintiuno);
        if(tileList[i].equals("14"))
            button.setBackgroundResource(R.drawable.veintidos);
        if(tileList[i].equals("13"))
            button.setBackgroundResource(R.drawable.veintitres);
        if(tileList[i].equals("12"))
            button.setBackgroundResource(R.drawable.veinticuatro);
        if(tileList[i].equals("11"))
            button.setBackgroundResource(R.drawable.vieinticinco);
        if(tileList[i].equals("10"))
            button.setBackgroundResource(R.drawable.veintiseis);
        if(tileList[i].equals("9"))
            button.setBackgroundResource(R.drawable.veintisiete);
        if(tileList[i].equals("8"))
            button.setBackgroundResource(R.drawable.veintiocho);
        if(tileList[i].equals("7"))
            button.setBackgroundResource(R.drawable.veintinueve);
        if(tileList[i].equals("6"))
            button.setBackgroundResource(R.drawable.treinta);
        if(tileList[i].equals("5"))
            button.setBackgroundResource(R.drawable.treintayuno);
        if(tileList[i].equals("4"))
            button.setBackgroundResource(R.drawable.treintaydos);
        if(tileList[i].equals("3"))
            button.setBackgroundResource(R.drawable.treintaytres);
        if(tileList[i].equals("2"))
            button.setBackgroundResource(R.drawable.treintaycuatro);
        if(tileList[i].equals("1"))
            button.setBackgroundResource(R.drawable.treintaycinco);
        if(tileList[i].equals("0"))
            button.setBackgroundResource(R.drawable.treintayseis);
        buttons.add(button);
        }
    mGridView.setAdapter(new CustomAdapter(buttons,mColumnWidth,mColumnHeight));
    }

    private void scramble(){
        int index;
        String temp;
        Random random= new Random();

        for (int i=tileList.length-1; i<0;i--){
            index =random.nextInt(i + 1);
            temp=tileList[index];
            tileList[index]=tileList[i];
            tileList[i]=temp;

    }
    }
private void init() {
    mGridView = (GestureDetectGridView) findViewById(R.id.grid);
    mGridView.setNumColumns(Columnas);
    tileList = new String[Dimensiones];
    for (int i = 0; i < Dimensiones; i++) {
        tileList[i] = String.valueOf(i);
    }
}
private static void swap(Context context, int position,int swap) {
String newPosition=tileList[position+swap];
tileList[position+swap]=tileList[position];
tileList[position]=newPosition;
display(context);
if (isSolved()){
    Toast.makeText(context, "You win!", Toast.LENGTH_SHORT).show();
}
    }
private static boolean isSolved() {
    boolean solved = false;
    for (int i = 0; i < tileList.length; i++) {
        if (tileList[i].equals(String.valueOf(i))) {
            solved = true;
        } else {
            solved = false;
            break;
        }
    }
    return solved;
}

public static void moveTiles(Context context,String direction,int position){
        if (position==0) {
            if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, Columnas);
             else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                } else if (position > 0 && position < Columnas - 1) {
                    if (direction.equals(left)) swap(context, position, -1);
                    else if (direction.equals(down)) swap(context, position, Columnas);
                    else if (direction.equals(right)) swap(context, position, 1);
                    else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                } else if (position==Columnas - 1) {

                    if (direction.equals(left)) swap(context, position, -1);
                    else if (direction.equals(down)) swap(context, position, Columnas);
                    else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

        }else if (position>Columnas-1 && position<Dimensiones-Columnas&&position%Columnas==0){
            if(direction.equals(up))swap(context,position,Columnas);
            else if (direction.equals(right))swap(context,position,1);
            else if (direction.equals(down))swap(context,position,Columnas);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            } else if (position==Columnas*2-1||position==Columnas*3-1){
            if (direction.equals(up)) swap(context,position,-Columnas);
            else if (direction.equals(left))swap(context,position,-1);
            else if (direction.equals(down)) {

                if (position <= Dimensiones - Columnas - 1) swap(context, position, Columnas);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

        } else if (position == Dimensiones - Columnas) {
            if (direction.equals(up))swap(context,position,-Columnas);
            else if (direction.equals(right))swap(context,position,1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

        }else if(position<Dimensiones-1&&position>Dimensiones-Columnas){
            if (direction.equals(up))swap(context,position,-Columnas);
            else if (direction.equals(left))swap(context,position,-1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();



        } else {if (direction.equals(up))swap(context,position,-Columnas);
            else if (direction.equals(left))swap(context,position,-1);
                else if (direction.equals(right))swap(context,position,1);
                else swap(context,position,Columnas);

        }}}