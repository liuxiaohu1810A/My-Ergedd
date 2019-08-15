package com.example.myergedd.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Table_Vp_Adapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;

    public Table_Vp_Adapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> strings) {
        super(fm);
        this.fragments = fragments;
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
