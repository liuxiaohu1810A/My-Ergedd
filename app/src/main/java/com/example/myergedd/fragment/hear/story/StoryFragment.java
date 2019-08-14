package com.example.myergedd.fragment.hear.story;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.adapter.HearStoryAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.fragment.hear.story.bean.HearStoryBean;
import com.example.myergedd.fragment.hear.story.contract.HearStory;
import com.example.myergedd.fragment.hear.story.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class StoryFragment extends BaseFragment<HearStory.HearStoryView,IPresenter<HearStory.HearStoryView>>implements HearStory.HearStoryView {

    private RecyclerView res;
    private HearStoryAdapter hearStoryAdapter;
    private SmartRefreshLayout mSmart;
    private int page=0;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }


    @Override
    protected void initData() {
        mPresenter.setHearStoryData();
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.englishRes);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        hearStoryAdapter = new HearStoryAdapter(getActivity());
        res.setAdapter(hearStoryAdapter);
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
    protected IPresenter<HearStory.HearStoryView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    public void onSuccess(List<HearStoryBean> hearStoryBeanList) {
        hearStoryAdapter.setHearStoryBeans(hearStoryBeanList);
    }

    @Override
    public void onFailed(String error) {

    }

}
