package com.ron.exploreapp.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ron.exploreapp.frag_search_rest.images_search_rest;
import com.ron.exploreapp.frag_search_rest.overview_search_rest;
import com.ron.exploreapp.frag_search_rest.review_search_rest;

public class frag_search_rest_adapter extends FragmentPagerAdapter {
    @NonNull
    int no_tab;
    String desc;
    String place;
    public frag_search_rest_adapter(@NonNull FragmentManager fm, int no_tab, String desc, String place) {
        super(fm);
        this.no_tab = no_tab;
        this.desc=desc;
        this.place=place;
    }

    public Fragment getItem(int position) {
        switch (position){

            case 0: overview_search_rest overview=new overview_search_rest();
                Bundle bundle=new Bundle();
                bundle.putString("desc",desc);
                overview.setArguments(bundle);
                return overview;
            case 1: images_search_rest images=new images_search_rest();
                Bundle bundle1=new Bundle();
                bundle1.putString("place",place);
                images.setArguments(bundle1);
                return images;
            case 2: review_search_rest review=new review_search_rest();
                return review;
            default:return null;

        }
    }

    @Override
    public int getCount() {
        return no_tab;
    }
}




