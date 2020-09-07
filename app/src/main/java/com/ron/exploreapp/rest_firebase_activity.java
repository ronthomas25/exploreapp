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

public class rest_firebase_activity extends AppCompatActivity {
    String desc,uri,url;
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
        setContentView(R.layout.activity_rest_firebase_activity);

        img=findViewById(R.id.placeimg);
        state=findViewById(R.id.state);
        ratingBar=findViewById(R.id.ratingBar);
        rating=findViewById(R.id.rating);
        gps=findViewById(R.id.gps_icon);
        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsinglayout);

      /*  Bundle bundle= getIntent().getExtras();
        List<sample_firebasedata> restaurentData=(List<sample_firebasedata>)bundle.getSerializable("data");
        pos=getIntent().getIntExtra("pos",0);*/

        Intent i=getIntent();
        collapsingToolbarLayout.setTitle(i.getStringExtra("place"));
        Glide.with(getApplicationContext()).load(i.getStringExtra("image")).into(img);
        desc=i.getStringExtra("desc");
        state.setText(i.getStringExtra("state"));
        ratingBar.setRating(i.getFloatExtra("rating",0));
        rating.setText(i.getFloatExtra("rating",0)+"");
        lat=i.getFloatExtra("lat",0);
        lon=i.getFloatExtra("lon",0);
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
