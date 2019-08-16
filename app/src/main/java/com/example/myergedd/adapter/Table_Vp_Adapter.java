package com.example.myergedd.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Table_Vp_Adapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fm;

    public Table_Vp_Adapter(FragmentManager fm, ArrayList<Fragment> fm1) {
        super(fm);
        this.fm = fm1;
    }

    @Override
    public Fragment getItem(int i) {
        return fm.get(i);
    }

    @Override
    public int getCount() {
        return fm.size();
    }
}
