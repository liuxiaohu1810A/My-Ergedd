package com.example.myergedd.fragment.cache.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.adapter.VideoRecommendAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.RecommendBean;
import com.example.myergedd.fragment.cache.video.cartoon.Recommend;
import com.example.myergedd.fragment.cache.video.presenter.IPresenter;

import java.util.List;

public class Video_Fragment extends BaseFragment<Recommend.RecommendView, IPresenter<Recommend.RecommendView>> implements Recommend.RecommendView {
    private View view;
    private RecyclerView mVoiceRecommendRecy;
    private VideoRecommendAdapter videoRecommendAdapter;
    private static final String TAG = "Video_Fragment";

    @Override
    protected int getLayoutID() {
        return R.layout.cache_video_recommend;
    }


    public void initView(View view) {
        mVoiceRecommendRecy = (RecyclerView) view.findViewById(R.id.voice_recommend_Recy);

        mVoiceRecommendRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        videoRecommendAdapter = new VideoRecommendAdapter(getActivity());
        mVoiceRecommendRecy.setAdapter(videoRecommendAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getRecommendData();
    }

    @Override
    public void OnSuccess(List<RecommendBean> recommendBeans) {
        videoRecommendAdapter.setItemBeans(recommendBeans);
    }

    @Override
    public void OnFailed(String error) {
        Log.i(TAG, "OnFailed: "+error);
    }

    @Override
    protected IPresenter<Recommend.RecommendView> initPresenter() {
        return new IPresenter<>();
    }
}
