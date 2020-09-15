package com.ron.exploreapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.util.TimerTask;

import static java.lang.System.exit;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean  conn=isconnected(getApplicationContext());
                if(conn == true) {
                    Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent1 = new Intent(SplashActivity.this, Nointernet.class);
                    startActivity(intent1);
                    finish();
                }
             }
        },SPLASH_TIME_OUT);
    }

    private boolean isconnected(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mob=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if((wifi !=null && wifi.isConnected()) || (mob!=null && mob.isConnected())) {
            return true;
        }
        else{
             return false;
            }

        }
}