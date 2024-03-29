package com.example.myergedd.fragment.see.story.presenter;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.StoryBean;
import com.example.myergedd.fragment.see.story.contract.Story;
import com.example.myergedd.fragment.see.story.model.IModel;

import java.util.List;

public class IPresenter<V extends Story.StoryView> extends BasePresenter<V> implements Story.StoryPresenter {
    private Story.StoryModel model = new IModel();

    @Override
    public void setStoryData() {
        if (mView != null) {
            model.getStory(new BaseCallBack<List<StoryBean>>() {
                @Override
                public void onSuccessful(List<StoryBean> storyBeanList) {
                    mView.onSuccess(storyBeanList);
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
