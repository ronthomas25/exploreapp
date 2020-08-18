package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SearchActivity extends BaseActivity {


    @Override
    int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.action_search;
    }


}