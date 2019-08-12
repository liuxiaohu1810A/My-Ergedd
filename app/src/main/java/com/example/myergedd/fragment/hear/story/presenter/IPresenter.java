package com.example.myergedd.fragment.hear.story.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.story.bean.HearStoryBean;
import com.example.myergedd.fragment.hear.story.contract.HearStory;
import com.example.myergedd.fragment.hear.story.model.IModel;

import java.util.List;

public class IPresenter<V extends HearStory.HearStoryView> extends BasePresenter<V> implements HearStory.HearStoryPresenter {
    private HearStory.HearStoryModel model = new IModel();

    @Override
    public void setHearStoryData() {
        if (mView != null) {
            model.getHearStory(new BaseCallBack<List<HearStoryBean>>() {
                @Override
                public void onSuccessful(List<HearStoryBean> hearStoryBeanList) {
                    mView.onSuccess(hearStoryBeanList);
                }

                @Override
                public void onFiled(String filed) {
                    if (filed != null) {
                        mView.onFailed(filed);
                    }

                }
            });
        }
    }
}
