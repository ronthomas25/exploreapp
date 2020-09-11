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
import com.ron.exploreapp.model_data.mostsearched_data;

import java.util.List;

public class mostsearched_activity extends AppCompatActivity {
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
        setContentView(R.layout.activity_mostsearched_activity);

        img=findViewById(R.id.placeimg);
        state=findViewById(R.id.state);
        ratingBar=findViewById(R.id.ratingBar);
        rating=findViewById(R.id.rating);
        gps=findViewById(R.id.gps_icon);
        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsinglayout);

        Bundle bundle= getIntent().getExtras();
        List<mostsearched_data> mostsearchedData=(List<mostsearched_data>)bundle.getSerializable("data");
        pos=getIntent().getIntExtra("pos",0);

        collapsingToolbarLayout.setTitle(mostsearchedData.get(pos).getPlace());
        Glide.with(getApplicationContext()).load(mostsearchedData.get(pos).getImg_inner()).into(img);
        desc=mostsearchedData.get(pos).getDesc();
        state.setText(mostsearchedData.get(pos).getState());
        ratingBar.setRating(mostsearchedData.get(pos).getRating());
        rating.setText(mostsearchedData.get(pos).getRating()+"");
        lat=mostsearchedData.get(pos).getLat();
        lon=mostsearchedData.get(pos).getLon();
        uri="geo:"+lat+","+lon+"?q="+lat+","+lon+"";
        fragadapter(desc,mostsearchedData.get(pos).getPlace());
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            }
        });




    }
    public void fragadapter(String desc,String place)
    {
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);
        frag_mostsrc_adapter fragMostsrcAdapter=new frag_mostsrc_adapter(getSupportFragmentManager(), tabLayout.getTabCount(),desc,place);
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