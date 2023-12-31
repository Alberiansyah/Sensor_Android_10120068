package com.example.sensor_android_10120068;

/**
 * NIM      : 10120068
 * Nama     : Alberiansyah
 * Kelas    : IF-2
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.sensor_android_10120068.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import adapter.AdapterViewPagger;
import fragment.FragmentHome;
import fragment.FragmentInfo;
import fragment.FragmentLokasiSaya;
import fragment.FragmentRestoran;

public class MainActivity extends AppCompatActivity {
    ViewPager2 pagerMain;
    ArrayList<Fragment> fragmentsArrayList = new ArrayList<>();
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pagerMain = findViewById(R.id.pagerMain);

        fragmentsArrayList.add(new FragmentHome());
        fragmentsArrayList.add(new FragmentRestoran());
        fragmentsArrayList.add(new FragmentLokasiSaya());
        fragmentsArrayList.add(new FragmentInfo());

        AdapterViewPagger adapterViewPagger = new AdapterViewPagger(this, fragmentsArrayList);
        pagerMain.setAdapter(adapterViewPagger);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigation.setSelectedItemId(R.id.home);
                        break;
                    case 1:
                        bottomNavigation.setSelectedItemId(R.id.lokasi);
                        break;
                    case 2:
                        bottomNavigation.setSelectedItemId(R.id.lokasiSaya);
                        break;
                    case 3:
                        bottomNavigation.setSelectedItemId(R.id.info);
                        break;
                }
                super.onPageSelected(position);
            }
        });
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        pagerMain.setCurrentItem(0);
                        break;
                    case R.id.lokasi:
                        pagerMain.setCurrentItem(1);
                        break;
                    case R.id.lokasiSaya:
                        pagerMain.setCurrentItem(2);
                        break;
                    case R.id.info:
                        pagerMain.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

    }

}