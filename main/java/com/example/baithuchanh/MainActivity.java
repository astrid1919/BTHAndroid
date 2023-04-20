package com.example.baithuchanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.baithuchanh.adapter.ViewPagerAdapter;
import com.example.baithuchanh.fragment.HorizontalFlip;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tab;
    private BottomNavigationView nav;
    private FloatingActionButton fab;
    private ViewPagerAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.vp);
        tab = findViewById(R.id.tab);
        nav = findViewById(R.id.nav);
        fab = findViewById(R.id.fab);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),3);
        pager.setPageTransformer(true,new HorizontalFlip());
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddWorkActivity.class);
                startActivity(intent);
            }
        });

        nav.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mWorks:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.mInfo:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.mStat:
                        pager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        nav.getMenu().findItem(R.id.mWorks).setChecked(true);
                        break;
                    case 1:
                        nav.getMenu().findItem(R.id.mInfo).setChecked(true);
                        break;
                    case 2:
                        nav.getMenu().findItem(R.id.mStat).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() > 0)
        {
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
        super.onBackPressed();
    }
}