package com.ron.exploreapp.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ron.exploreapp.frag_toppicks.images_toppicks;
import com.ron.exploreapp.frag_toppicks.overview_toppicks;
import com.ron.exploreapp.frag_toppicks.review_toppicks;
import com.ron.exploreapp.fragment_mostsrch.images;
import com.ron.exploreapp.fragment_mostsrch.overview;
import com.ron.exploreapp.fragment_mostsrch.review;

public class frag_toppicks_adapter  extends FragmentPagerAdapter {
    @NonNull
    int no_tab;
    String desc;
    String place;
    public frag_toppicks_adapter(@NonNull FragmentManager fm, int no_tab, String desc, String place) {
        super(fm);
        this.no_tab = no_tab;
        this.desc=desc;
        this.place=place;
    }

    public Fragment getItem(int position) {
        switch (position){

            case 0: overview_toppicks overview= new overview_toppicks();
                Bundle bundle=new Bundle();
                bundle.putString("desc",desc);
                overview.setArguments(bundle);
                return overview;
            case 1: images_toppicks images= new images_toppicks();
                Bundle bundle2=new Bundle();
                bundle2.putString("name",place);
                images.setArguments(bundle2);
                return images;
            case 2: review_toppicks review= new review_toppicks();
                return review;
            default:return null;

        }
    }

    @Override
    public int getCount() {
        return no_tab;
    }
}

