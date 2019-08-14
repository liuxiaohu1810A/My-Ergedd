package com.example.myergedd.fragment.see.synthesize;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.CommonSeeActivity;
import com.example.myergedd.adapter.SynthesizeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.SynthesizeBean;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.SynthesizeBean;
import com.example.myergedd.fragment.see.synthesize.contract.Synthesize;
import com.example.myergedd.fragment.see.synthesize.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import com.example.myergedd.bean.SynthesizeBean;
import java.util.List;

public class SynthesizeFragment extends BaseFragment<Synthesize.SynthesizeView,IPresenter<Synthesize.SynthesizeView>>implements Synthesize.SynthesizeView {

    private RecyclerView res;
    private SynthesizeAdapter synthesizeAdapter;
    public SmartRefreshLayout mSmart;
    private int page;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_synthesize;
    }

    @Override
    protected IPresenter<Synthesize.SynthesizeView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.synthesizeRes);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        synthesizeAdapter = new SynthesizeAdapter(getActivity());
        res.setAdapter(synthesizeAdapter);
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
    protected void initData() {
        mPresenter.setSynthesizeData();
    }

    @Override
    protected void initListener() {
        synthesizeAdapter.setOnClickListener(new SynthesizeAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), CommonSeeActivity.class);
                SynthesizeBean bean = synthesizeAdapter.synthesizeBeans.get(position);
                intent.putExtra("id", bean.getId());
                intent.putExtra("title", bean.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(List<SynthesizeBean> synthesizeBeanList) {
        synthesizeAdapter.setSynthesizeBeans(synthesizeBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
