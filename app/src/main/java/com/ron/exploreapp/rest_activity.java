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
import com.ron.exploreapp.adapter.frag_rest_adapter;
import com.ron.exploreapp.model_data.popular_restaurent_data;

import java.util.List;

public class rest_activity extends AppCompatActivity {
    String desc,uri;
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
        setContentView(R.layout.activity_rest_activity);
        img=findViewById(R.id.placeimg);
        state=findViewById(R.id.state);
        ratingBar=findViewById(R.id.ratingBar);
        rating=findViewById(R.id.rating);
        gps=findViewById(R.id.gps_icon);
        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsinglayout);

        Bundle bundle= getIntent().getExtras();
        List<popular_restaurent_data> restaurentData=(List<popular_restaurent_data>)bundle.getSerializable("data");
        pos=getIntent().getIntExtra("pos",0);

        collapsingToolbarLayout.setTitle(restaurentData.get(pos).getPlacename());
        Glide.with(getApplicationContext()).load(restaurentData.get(pos).getImg()).into(img);
        desc=restaurentData.get(pos).getDesc();
        state.setText(restaurentData.get(pos).getState());
        ratingBar.setRating(restaurentData.get(pos).getRating());
        rating.setText(restaurentData.get(pos).getRating()+"");
        lat=restaurentData.get(pos).getLat();
        lon=restaurentData.get(pos).getLon();
        uri="geo:"+lat+","+lon+"?q="+lat+","+lon+"";
        fragadapter(desc);
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            }
        });




    }
    public void fragadapter(String desc)
    {
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);
        frag_rest_adapter fragRestAdapter=new frag_rest_adapter(getSupportFragmentManager(), tabLayout.getTabCount(),desc);
        viewPager.setAdapter(fragRestAdapter);
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