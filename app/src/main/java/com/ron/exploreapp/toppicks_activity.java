package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.ron.exploreapp.adapter.frag_mostsrc_adapter;
import com.ron.exploreapp.model_data.top_picks_data;

import java.util.List;

public class toppicks_activity extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager viewPager;

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
        String desc;

        collapsingToolbarLayout=findViewById(R.id.collapsinglayout);
        placeimg=findViewById(R.id.placeimg);
        gps=findViewById(R.id.gps_icon);
        rating=findViewById(R.id.rating);
        ratingBar=findViewById(R.id.ratingBar);
        state=findViewById(R.id.state);

        Bundle bundle=getIntent().getExtras();
        List<top_picks_data> topPicksDataList= (List<top_picks_data>) bundle.getSerializable("data");
        pos=getIntent().getIntExtra("position",0);
        desc=topPicksDataList.get(pos).getDesc();
        Glide.with(getApplicationContext()).load(topPicksDataList.get(pos).getImage_inner()).into(placeimg);
        collapsingToolbarLayout.setTitle(topPicksDataList.get(pos).getPlace());
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
        fragadapter(desc);
    }

    public void fragadapter(String desc)
    {
            tabLayout=findViewById(R.id.tablayout);
            viewPager=findViewById(R.id.viewpager);
            frag_mostsrc_adapter fragMostsrcAdapter=new frag_mostsrc_adapter(getSupportFragmentManager(),tabLayout.getTabCount(),desc);
            viewPager.setAdapter(fragMostsrcAdapter);
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


}