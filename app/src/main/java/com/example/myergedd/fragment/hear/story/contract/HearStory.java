package com.example.myergedd.fragment.hear.story.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.story.bean.HearStoryBean;

import java.util.List;

public interface HearStory {
    public interface HearStoryView {
        void onSuccess(List<HearStoryBean> hearStoryBeanList);

        void onFailed(String error);
    }

    public interface HearStoryModel {
        void getHearStory(BaseCallBack<List<HearStoryBean>> HearStoryCallBack);
    }

    public interface HearStoryPresenter {
        void setHearStoryData();
    }
}
