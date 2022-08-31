package com.example.imeppac;
import  androidx.appcompat.app.AppCompatActivity;
import  android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.VideoView;
import  com.example.imeppac.FirstFragment;

public class splash  extends  AppCompatActivity{
    private VideoView mVideoView;
    private static int TIME_OUT = 3050;
@Override
    protected void onCreate (Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    SharedPreferences preferences =PreferenceManager.getDefaultSharedPreferences(splash.this);
    String path = preferences.getString("imeppacc",null) =="sonido" ?  "android.resource://"
            + getPackageName() + "/" + R.raw.imeppacc:"android.resource://" + getPackageName() + "/" + R.raw.imeppacc;
    Log.i("imeppacc",preferences.getString("imeppacc",null));
    mVideoView =(VideoView)findViewById(R.id.videoView);
    mVideoView.setVideoURI(Uri.parse(path));
    mVideoView.start();
    mVideoView.requestFocus();
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(splash.this, FirstFragment.class);
            startActivity(i);
            finish();
        }
    }, TIME_OUT);
}
}
