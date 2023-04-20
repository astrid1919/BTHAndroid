package com.example.baithuchanh.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.baithuchanh.fragment.Info_Fragment;
import com.example.baithuchanh.fragment.Stat_Fragment;
import com.example.baithuchanh.fragment.Works_Fragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int numPage;

    public ViewPagerAdapter(@NonNull FragmentManager fm,int behavior) {
        super(fm,behavior);
        numPage = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Works_Fragment();
            case 1:
                return new Info_Fragment();
            case 2:
                return new Stat_Fragment();
        }
        return new Works_Fragment();

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Works";
            case 1:
                return "Infomation";
            case 2:
                return "Search and Statistic";
        }
        return "Works";
    }

    @Override
    public int getCount() {
        return numPage;
    }
}
