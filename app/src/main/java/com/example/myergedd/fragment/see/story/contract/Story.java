package com.example.myergedd.fragment.see.story.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.see.StoryBean;

import java.util.List;

public interface Story {
    public interface StoryView {
        void onSuccess(List<StoryBean> storyBeanList);

        void onFailed(String error);
    }

    public interface StoryModel {
        void getStory(BaseCallBack<List<StoryBean>> storyCallBack);
    }

    public interface StoryPresenter {
        void setStoryData();
    }
}
