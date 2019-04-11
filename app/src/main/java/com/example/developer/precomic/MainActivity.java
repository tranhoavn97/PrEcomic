package com.example.developer.precomic;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView txtFulllname,txt_toolbar_til,txtAn;

    CircleImageView img_Avatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar=findViewById(R.id.mToolbar);
        txt_toolbar_til=findViewById(R.id.txt_toolbar_til);
        mToolbar.setTitle("");
        drawerLayout=findViewById(R.id.Drawerlayout);
        setUpActionBar();
        fragmentManager = getSupportFragmentManager();
        navigationView=findViewById(R.id.navigationview);
        //navigationView.setNavigationItemSelectedListener(this);
        FragmentTransaction ban = fragmentManager.beginTransaction();//
        HomeFragment hienLoaiSp = new HomeFragment();
        ban.replace(R.id.content, hienLoaiSp);
        ban.commit();
    }

    @SuppressLint("RestrictedApi")
    private void setUpActionBar() {
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, mToolbar, R.string.mo, R.string.dong) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);//ba lằng;
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        //navigationView.setItemIconTintList(null);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            drawerToggle.getDrawerArrowDrawable().setColor(getColor(R.color.colorwhite));
        } else {
            drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorwhite));
        }

    }
}
