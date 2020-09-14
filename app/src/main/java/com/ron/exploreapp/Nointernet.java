package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Nointernet extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nointernet);

         @SuppressLint("WrongViewCast") Button button =  findViewById(R.id.retrybutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean  conn=isconnected(getApplicationContext());
                if(conn == true) {
                    Intent intent = new Intent(Nointernet.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Nointernet.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }

            }
        });
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