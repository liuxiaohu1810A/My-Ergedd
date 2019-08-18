package com.example.myergedd.fragment.see.chosen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.CommonSeeActivity;

import com.example.myergedd.activity.VideoActivity;
import com.example.myergedd.adapter.ChosenAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.ChosenThree;
import com.example.myergedd.bean.ChosenTwoBean;
import com.example.myergedd.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class ChosenFragment extends BaseFragment<Chosen.ChosenView, ChosenPresenter<Chosen.ChosenView>> implements Chosen.ChosenView {
    private RecyclerView mRlv;
    private ChosenAdapter mAdapter;
    public SmartRefreshLayout mSmart;
    private int page;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_chosen;
    }

    @Override
    protected void initView(View view) {
        mRlv = view.findViewById(R.id.chosen_rlv);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ChosenAdapter(getActivity());
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.setDataTwo();
        mPresenter.setDataThree();
    }

    @Override
    protected void initListener() {
        mAdapter.setOnClickListener(new ChosenAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), CommonSeeActivity.class);
                ChosenTwoBean bean = mAdapter.mTwoBeans.get(position);
                intent.putExtra("id", bean.getId());
                intent.putExtra("title", bean.getName());
                startActivity(intent);
            }
        });
        mAdapter.setOnVideoClickListener(new ChosenAdapter.onVideoClickListener() {
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                ChosenThree.ItemBean item = mAdapter.mThrees.get(position).getItem();
                intent.putExtra("video",item.getResource());
                intent.putExtra("name",item.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    protected ChosenPresenter<Chosen.ChosenView> initPresenter() {
        return new ChosenPresenter<>();
    }

    @Override
    public void onSuccessTwo(final List<ChosenTwoBean> twoBeans) {
        if (twoBeans.size() > 0) {
            mAdapter.setDataTwo(twoBeans);

        }
        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mSmart.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                twoBeans.clear();
                page=0;
                initData();
                mSmart.finishRefresh();
            }
        });
    }

    @Override
    public void onSuccessThree(final List<ChosenThree> threes) {
        if (threes.size() > 0) {
            mAdapter.setDataThree(threes);
        }
        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mSmart.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                threes.clear();
                mSmart.finishRefresh();
            }
        });
    }

    @Override
    public void onFailed(String error) {
        if (error != null) {
            ToastUtils.ShowToast(error);
        }
    }
}
