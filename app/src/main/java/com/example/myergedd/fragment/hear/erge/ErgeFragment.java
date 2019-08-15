package com.example.myergedd.fragment.hear.erge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.myergedd.R;
import com.example.myergedd.adapter.Listen_ErgeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.fragment.hear.chosen.ChosenFragment;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;
import com.example.myergedd.fragment.hear.erge.contract.Erge;
import com.example.myergedd.fragment.hear.erge.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Unbinder;

public class ErgeFragment extends BaseFragment<Erge.ErgeView, IPresenter<Erge.ErgeView>> implements Erge.ErgeView {


    private Listen_ErgeAdapter adapter;
    private static final String TAG = "ErgeFragment";
    private RecyclerView englishRes;
    private SmartRefreshLayout mSmart;
    int page=0;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initView(View view) {
        englishRes = view.findViewById(R.id.englishRes);

        englishRes.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Listen_ErgeAdapter(getContext());
        englishRes.setAdapter(adapter);
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
        mPresenter.getListenErgeData();
    }

    @Override
    protected IPresenter<Erge.ErgeView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    public void OnSuccess(List<Listen_ErgeBean> listen_ergeBeans) {
        adapter.setList(listen_ergeBeans);
    }

    @Override
    public void OnFailed(String error) {
        Log.i(TAG, "OnFailed: " + error);
    }



}
