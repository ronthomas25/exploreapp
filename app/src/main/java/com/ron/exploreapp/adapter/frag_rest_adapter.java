package com.ron.exploreapp.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ron.exploreapp.frag_restactivity.images;
import com.ron.exploreapp.frag_restactivity.overview;
import com.ron.exploreapp.frag_restactivity.review;

public class frag_rest_adapter extends FragmentPagerAdapter {
    @NonNull
    int no_tab;
    String desc;
    String place;
    public frag_rest_adapter(@NonNull FragmentManager fm, int no_tab, String desc,String place) {
        super(fm);
        this.no_tab = no_tab;
        this.desc=desc;
        this.place=place;
    }

    public Fragment getItem(int position) {
        switch (position){

            case 0: overview overview=new overview();
                Bundle bundle=new Bundle();
                bundle.putString("desc",desc);
                overview.setArguments(bundle);
                return overview;
            case 1: images images=new images();
                  Bundle bundle1=new Bundle();
                  bundle1.putString("place",place);
                  images.setArguments(bundle1);
                  return images;
            case 2: review review=new review();
                return review;
            default:return null;

        }
    }

    @Override
    public int getCount() {
        return no_tab;
    }
}


