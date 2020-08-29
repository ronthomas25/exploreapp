package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AccountActivity extends BaseActivity {

    @Override
    int getLayoutId() {
        return R.layout.activity_account;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.action_account;
    }

    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnLogout = findViewById(R.id.logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(AccountActivity.this, SignUpActivity.class);
                startActivity(intToMain);
            }
        });
    }




}