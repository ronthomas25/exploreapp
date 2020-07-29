package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class vagamonactivity extends MainActivity {

    public void onClickBackVagamon(View view){
        Intent i = new Intent(vagamonactivity.this,MainActivity.class);
        startActivity(i);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vagamon);
    }
}