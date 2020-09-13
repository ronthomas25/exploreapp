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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.ron.exploreapp.adapter.frag_rest_adapter;
import com.ron.exploreapp.model_data.popular_restaurent_data;
import com.ron.exploreapp.model_data.search_rest_data;

import java.util.List;

public class rest_search_activity extends AppCompatActivity {

    String desc,uri,place;
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
        List<search_rest_data> restaurentData=(List<search_rest_data>)bundle.getSerializable("data");
        int pos=0;

        collapsingToolbarLayout.setTitle(restaurentData.get(pos).getPlace());
        Glide.with(getApplicationContext()).load(restaurentData.get(pos).getImageInner()).into(img);
        desc=restaurentData.get(pos).getDesc();
        state.setText(restaurentData.get(pos).getState());
        ratingBar.setRating(restaurentData.get(pos).getRating());
        rating.setText(restaurentData.get(pos).getRating()+"");
        lat=restaurentData.get(pos).getLat();
        lon=restaurentData.get(pos).getLon();
        uri="geo:"+lat+","+lon+"?q="+lat+","+lon+"";
        place=restaurentData.get(pos).getPlace();
        Toast.makeText(getApplicationContext(),place.toLowerCase(),Toast.LENGTH_SHORT).show();
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            }
        });
        fragadapter(desc,place);



    }
    public void fragadapter(String desc,String place)
    {
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);
        frag_rest_adapter fragRestAdapter=new frag_rest_adapter(getSupportFragmentManager(), tabLayout.getTabCount(),desc,place);
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