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
import com.ron.exploreapp.adapter.frag_loc_adapter;
import com.ron.exploreapp.adapter.frag_mostsrc_adapter;
import com.ron.exploreapp.model_data.location_data;
import com.ron.exploreapp.model_data.mostsearched_data;

import java.util.List;

public class loc_search_activity extends AppCompatActivity {

    String desc,uri,placename;
    TextView rating,state;
    int pos;
    float lat,lon;
    ImageView img,backbtn,gps;
    RatingBar ratingBar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc_search_activity);

        img=findViewById(R.id.placeimg);
        state=findViewById(R.id.state);
        backbtn=findViewById(R.id.backbtn);
        ratingBar=findViewById(R.id.ratingBar);
        rating=findViewById(R.id.rating);
        gps=findViewById(R.id.gps_icon);
        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsinglayout);

        Bundle bundle= getIntent().getExtras();
        List<location_data> locationData=(List<location_data>)bundle.getSerializable("data");
        pos=getIntent().getIntExtra("pos",0);

        collapsingToolbarLayout.setTitle(locationData.get(pos).getPlace());
        //Glide.with(getApplicationContext()).load(locationData.get(pos).getImg_inner()).into(img);
      //  desc=locationData.get(pos).getDesc();
        state.setText(locationData.get(pos).getState());
        //ratingBar.setRating(locationData.get(pos).getRating());
      //  rating.setText(locationData.get(pos).getRating()+"");
        lat=locationData.get(pos).getLat();
        lon=locationData.get(pos).getLon();
        uri="geo:"+lat+","+lon+"?q="+lat+","+lon+"";
        placename=locationData.get(pos).getPlace();
        fragadapter(placename);
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loc_search_activity.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
    public void fragadapter(String placename)
    {
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);
        frag_loc_adapter fragLocAdapter=new frag_loc_adapter(getSupportFragmentManager(),tabLayout.getTabCount(),placename);
        viewPager.setAdapter(fragLocAdapter);
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
