package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class munnaractivity extends MainActivity {

    public void onClickBackMunnar(View view){
        Intent i = new Intent(munnaractivity.this,MainActivity.class);
        startActivity(i);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munnar);
    }


}