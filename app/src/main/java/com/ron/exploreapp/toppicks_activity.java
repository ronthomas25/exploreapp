package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.ron.exploreapp.model_data.top_picks_data;

import java.util.List;

public class toppicks_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppicks_activity);

        CollapsingToolbarLayout collapsingToolbarLayout;
        ImageView placeimg,backbtn,gps;
        TextView state,rating;
        RatingBar ratingBar;
        int pos;
        float lat,lon;
        final String uri;

        collapsingToolbarLayout=findViewById(R.id.collapsinglayout);
        placeimg=findViewById(R.id.placeimg);
        gps=findViewById(R.id.gps_icon);
        rating=findViewById(R.id.rating);
        ratingBar=findViewById(R.id.ratingBar);
        state=findViewById(R.id.state);

        Bundle bundle=getIntent().getExtras();
        List<top_picks_data> topPicksDataList= (List<top_picks_data>) bundle.getSerializable("data");
        pos=getIntent().getIntExtra("position",0);
        placeimg.setImageResource(topPicksDataList.get(pos).getImg(1));
        collapsingToolbarLayout.setTitle(topPicksDataList.get(pos).getPlacename());
        state.setText(topPicksDataList.get(pos).getState());
        rating.setText(topPicksDataList.get(pos).getRating()+"");
        ratingBar.setRating((float) topPicksDataList.get(pos).getRating());
        lat= (float) topPicksDataList.get(pos).getLat();
        lon= (float) topPicksDataList.get(pos).getLon();
        uri="geo:"+lat+","+lon+"?q="+lat+","+lon+"";
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            }
        });

    }
}