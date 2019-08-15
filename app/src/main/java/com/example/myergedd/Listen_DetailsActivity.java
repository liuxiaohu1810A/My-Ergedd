package com.example.myergedd;

import android.os.Bundle;

import com.example.myergedd.base.SimpleActivity;

public class Listen_DetailsActivity extends SimpleActivity {
    @Override
    protected int getLayoutID() {
        return R.layout.activity_listen__details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.activity_listen__details);
        initView();
    }

    public void initView() {
    }
}
