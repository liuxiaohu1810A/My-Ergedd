package com.example.myergedd.fragment.see.story;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.adapter.see.StoryAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.see.StoryBean;
import com.example.myergedd.fragment.see.story.contract.Story;
import com.example.myergedd.fragment.see.story.presenter.IPresenter;

import java.util.List;

public class StoryFragment extends BaseFragment<Story.StoryView,IPresenter<Story.StoryView>>implements Story.StoryView {

    private RecyclerView res;
    private StoryAdapter storyAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_story;
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.storyRes);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        storyAdapter = new StoryAdapter(getActivity());
        res.setAdapter(storyAdapter);
    }

    @Override
    protected IPresenter<Story.StoryView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    protected void initData() {
        mPresenter.setStoryData();
    }

    @Override
    public void onSuccess(List<StoryBean> storyBeanList) {
        storyAdapter.setAlbumsBeans(storyBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
