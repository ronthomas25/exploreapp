package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class gridview_image_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_image_activity);
        PhotoView image=findViewById(R.id.photoview);
        Intent intent=getIntent();
        String url=intent.getStringExtra("image");
        Glide.with(getApplicationContext()).load(url).into(image);
    }
}