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
    public frag_rest_adapter(@NonNull FragmentManager fm, int no_tab, String desc) {
        super(fm);
        this.no_tab = no_tab;
        this.desc=desc;
    }

    public Fragment getItem(int position) {
        switch (position){

            case 0: overview overview=new overview();
                Bundle bundle=new Bundle();
                bundle.putString("desc",desc);
                overview.setArguments(bundle);
                return overview;
            case 1: images images=new images();
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


