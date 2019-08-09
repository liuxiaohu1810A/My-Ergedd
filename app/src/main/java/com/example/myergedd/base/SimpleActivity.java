package com.example.myergedd.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMvp();
        mUnbinder = ButterKnife.bind(this);
        setContentView(getLayoutID());
        initView();
        initData();
        initListener();
    }

    protected void initMvp() {
    }

    protected void initListener() {
    }

    protected void initData() {
    }

    protected void initView() {
    }


    protected abstract int getLayoutID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
