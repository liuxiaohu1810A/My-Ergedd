package com.example.myergedd.fragment.see.chosen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myergedd.R;
import com.example.myergedd.activity.CommonSeeActivity;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.see.ChosenThree;
import com.example.myergedd.bean.see.ChosenTwoBean;
import com.example.myergedd.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class ChosenFragment extends BaseFragment<Chosen.ChosenView, ChosenPresenter<Chosen.ChosenView>> implements Chosen.ChosenView {

    private RecyclerView mRlv;
    private ChosenAdapter mAdapter;
    private View view;
    private SmartRefreshLayout mSmart;
    int page=0;
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_chosen;
    }

    @Override
    protected void initView(View view) {
        mRlv = view.findViewById(R.id.chosen_rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ChosenAdapter(getActivity());
        mRlv.setAdapter(mAdapter);
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
    }

    @Override
    protected ChosenPresenter<Chosen.ChosenView> initPresenter() {
        return new ChosenPresenter<>();
    }

    @Override
    public void onSuccessTwo(List<ChosenTwoBean> twoBeans) {
        if (twoBeans.size() > 0) {
            mAdapter.setDataTwo(twoBeans);
        }
    }

    @Override
    public void onSuccessThree(List<ChosenThree> threes) {
        if (threes.size() > 0) {
            mAdapter.setDataThree(threes);
        }
    }

    @Override
    public void onFailed(String error) {
        if (error != null) {
            ToastUtils.ShowToast(error);
        }
    }

}
