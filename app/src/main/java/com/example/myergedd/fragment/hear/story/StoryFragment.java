package com.example.myergedd.fragment.hear.story;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.DetailsActivity;
import com.example.myergedd.R;
import com.example.myergedd.adapter.HearStoryAdapter;
import com.example.myergedd.adapter.Listen_ErgeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;
import com.example.myergedd.fragment.hear.story.bean.HearStoryBean;
import com.example.myergedd.fragment.hear.story.contract.HearStory;
import com.example.myergedd.fragment.hear.story.presenter.IPresenter;

import java.util.List;

public class StoryFragment extends BaseFragment<HearStory.HearStoryView,IPresenter<HearStory.HearStoryView>>implements HearStory.HearStoryView {

    private RecyclerView res;
    private HearStoryAdapter hearStoryAdapter;


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
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        hearStoryAdapter = new HearStoryAdapter(getActivity());
        res.setAdapter(hearStoryAdapter);
        hearStoryAdapter.setOnclcik(new HearStoryAdapter.OnClick() {
            @Override
            public void onclcik(HearStoryBean hearStoryBean) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("name",hearStoryBean.getName());
                intent.putExtra("desc",hearStoryBean.getDescription());
                intent.putExtra("count",hearStoryBean.getCount());
                intent.putExtra("img",hearStoryBean.getSquare_image_url());
                startActivity(intent);
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
