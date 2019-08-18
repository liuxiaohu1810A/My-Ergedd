package com.example.myergedd.fragment.hear.erge;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.DetailsActivity;
import com.example.myergedd.adapter.Listen_ErgeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;
import com.example.myergedd.fragment.hear.erge.contract.Erge;
import com.example.myergedd.fragment.hear.erge.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

public class ErgeFragment extends BaseFragment<Erge.ErgeView, IPresenter<Erge.ErgeView>> implements Erge.ErgeView {


    private ArrayList<Listen_ErgeBean> list;
    private Listen_ErgeAdapter adapter;
    private static final String TAG = "ErgeFragment";
    private RecyclerView englishRes;
    private SmartRefreshLayout mSmart;
    private int page=0;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initView(View view) {
        englishRes = view.findViewById(R.id.englishRes);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        englishRes.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Listen_ErgeAdapter(getContext());
        englishRes.setAdapter(adapter);

        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mSmart.finishLoadMore();
            }
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mSmart.finishRefresh();
            }
        });
    }

    @Override
    protected void initListener() {
        adapter.setOnclick(new Listen_ErgeAdapter.OnClick() {
            @Override
            public void onclcick(Listen_ErgeBean listen_ergeBean) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("id", listen_ergeBean.getId());
                intent.putExtra("name", listen_ergeBean.getName());
                intent.putExtra("count",listen_ergeBean.getCount());
                intent.putExtra("url",listen_ergeBean.getSquare_image_url());
                intent.putExtra("description",listen_ergeBean.getDescription());
                startActivity(intent);
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
        adapter.setListen_ergeAdapters(listen_ergeBeans);
    }

    @Override
    public void OnFailed(String error) {
        Log.i(TAG, "OnFailed: " + error);
    }
}
