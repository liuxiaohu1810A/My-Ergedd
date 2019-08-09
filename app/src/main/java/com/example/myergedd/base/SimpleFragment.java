package com.example.myergedd.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleFragment extends Fragment {

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initMvp();
        View view = inflater.inflate(getLayoutID(), null);
        mUnbinder = ButterKnife.bind(getActivity());
        initView(view);
        initData();
        initListener();
        return view;
    }

    protected void initMvp() {
    }

    protected void initListener() {
    }

    protected void initData() {
    }

    protected void initView(View view) {
    }

    protected abstract int getLayoutID();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
