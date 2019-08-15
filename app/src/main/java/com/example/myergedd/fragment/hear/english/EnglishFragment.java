package com.example.myergedd.fragment.hear.english;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.myergedd.R;
import com.example.myergedd.adapter.HearEnglishAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.english.contract.HearEnglish;
import com.example.myergedd.fragment.hear.english.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class EnglishFragment extends BaseFragment<HearEnglish.HearEnglishView,IPresenter<HearEnglish.HearEnglishView>>implements HearEnglish.HearEnglishView {

    private RecyclerView res;
    private HearEnglishAdapter hearEnglishAdapter;
    private SmartRefreshLayout mSmart;
    int page=0;


    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initView(View view) {

        res = view.findViewById(R.id.englishRes);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        hearEnglishAdapter = new HearEnglishAdapter(getActivity());
        res.setAdapter(hearEnglishAdapter);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=0;
                initData();
                mSmart.finishRefresh();
            }
        });
    }

    @Override
    protected void initData() {

        mPresenter.setHearEnglishData();
    }

    @Override
    protected IPresenter<HearEnglish.HearEnglishView> initPresenter() {
        return new IPresenter<>();
    }

    @Override

    public void onSuccess(List<HearEnglishBean> hearEnglishBeanList) {
        hearEnglishAdapter.setMusicBeans(hearEnglishBeanList);
    }

    @Override
    public void onFailed(String error) {

    }

}
