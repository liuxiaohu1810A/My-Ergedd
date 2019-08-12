package com.example.myergedd.fragment.hear.story.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.story.bean.HearStoryBean;
import com.example.myergedd.fragment.hear.story.contract.HearStory;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements HearStory.HearStoryModel {
    @Override
    public void getHearStory(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getHearStoryData()
                .compose(RxJavaUtils.<BaseResponse<List<HearStoryBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<HearStoryBean>>changeResult())
                .subscribe(new BaseObserver<List<HearStoryBean>>() {
                    @Override
                    public void onSuccessful(List<HearStoryBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
