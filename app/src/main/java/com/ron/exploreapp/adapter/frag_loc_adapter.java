package com.ron.exploreapp.adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ron.exploreapp.frag_location.Attractions;
import com.ron.exploreapp.frag_location.Entertainment;
import com.ron.exploreapp.frag_location.Restaurents;
import com.ron.exploreapp.model_data.location_data;

import java.util.List;

public class frag_loc_adapter extends FragmentPagerAdapter {
     @NonNull
     int no_tab;
     String name;
     public frag_loc_adapter(@NonNull FragmentManager fm,int no_tab,String name) {
        super(fm);
        this.no_tab=no_tab;
        this.name=name;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                Restaurents restaurents=new Restaurents();
                Bundle bundle=new Bundle();
                bundle.putString("placename",name);
                restaurents.setArguments(bundle);
                return restaurents;

            case 1:
                Entertainment entertainment=new Entertainment();
                Bundle bundle1=new Bundle();
                bundle1.putString("placename",name);
                entertainment.setArguments(bundle1);
                return entertainment;


            case 2:
                   Attractions attractions=new Attractions();
                Bundle bundle2=new Bundle();
                bundle2.putString("placename",name);
                attractions.setArguments(bundle2);
                   return attractions;




            default:   return null;
        }

    }

    @Override
    public int getCount() {
        return no_tab;
    }
}
