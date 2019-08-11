package com.example.myergedd.fragment.chosen;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.base.SimpleFragment;

public class ChosenFragment extends SimpleFragment {

    private RecyclerView mRlv;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_chosen;
    }

    @Override
    protected void initView(View view) {
        mRlv = view.findViewById(R.id.chosen_rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
