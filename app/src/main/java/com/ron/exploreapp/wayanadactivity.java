package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class wayanadactivity extends MainActivity {

    public void onClickBackWayanad(View view){
        Intent i = new Intent(wayanadactivity.this,MainActivity.class);
        startActivity(i);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(wayanadactivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wayanad);
    }
}