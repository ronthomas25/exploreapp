package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NotificationActivity extends BaseActivity {
    @Override
    int getLayoutId() {
        return R.layout.activity_notification;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.action_notification;
    }


}