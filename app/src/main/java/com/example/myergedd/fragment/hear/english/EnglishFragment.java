package com.example.myergedd.fragment.hear.english;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.DetailsActivity;
import com.example.myergedd.adapter.HearEnglishAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.english.contract.HearEnglish;
import com.example.myergedd.fragment.hear.english.presenter.IPresenter;
import com.example.myergedd.fragment.hear.story.bean.HearStoryBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class EnglishFragment extends BaseFragment<HearEnglish.HearEnglishView,IPresenter<HearEnglish.HearEnglishView>>implements HearEnglish.HearEnglishView {

    private RecyclerView res;
    private HearEnglishAdapter hearEnglishAdapter;
    private SmartRefreshLayout mSmart;
    private int page=0;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initListener() {
        hearEnglishAdapter.setOnClickListener(new HearEnglishAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                HearEnglishBean englishBean = hearEnglishAdapter.hearEnglishBeans.get(position);
                intent.putExtra("id", englishBean.getId());
                intent.putExtra("name", englishBean.getName());
                intent.putExtra("count",englishBean.getCount());
                intent.putExtra("url",englishBean.getSquare_image_url());
                intent.putExtra("description",englishBean.getDescription());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView(View view) {
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        res = view.findViewById(R.id.englishRes);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        hearEnglishAdapter = new HearEnglishAdapter(getActivity());
        res.setAdapter(hearEnglishAdapter);
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
