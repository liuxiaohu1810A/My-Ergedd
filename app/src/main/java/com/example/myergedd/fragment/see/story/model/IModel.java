package com.example.myergedd.fragment.see.story.model;
import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.StoryBean;
import com.example.myergedd.fragment.see.story.contract.Story;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements Story.StoryModel {
    @Override
    public void getStory(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getStoryData()
                .compose(RxJavaUtils.<BaseResponse<List<StoryBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<StoryBean>>changeResult())
                .subscribe(new BaseObserver<List<StoryBean>>() {
                    @Override
                    public void onSuccessful(List<StoryBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
