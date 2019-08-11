package com.example.myergedd.fragment.erge;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myergedd.R;
import com.example.myergedd.base.SimpleFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ErgeFragment extends SimpleFragment {
    @BindView(R.id.rlv)
    RecyclerView rlv;


    @Override
    protected int getLayoutID() {
        return R.layout.fragment_erge;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
