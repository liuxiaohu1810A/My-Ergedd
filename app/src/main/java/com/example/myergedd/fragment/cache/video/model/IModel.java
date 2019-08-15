package com.example.myergedd.fragment.cache.video.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.RecommendBean;
import com.example.myergedd.fragment.cache.video.cartoon.Recommend;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

import io.reactivex.functions.Consumer;

public class IModel implements Recommend.RecommendModel {
    @Override
    public void getRecommendData(final BaseCallBack<List<RecommendBean>> baseCallBack) {
        HttpManager.getInstance().getServer(ApiServier.class)
                .getRecommendBean()
                .compose(RxJavaUtils.<BaseResponse<List<RecommendBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<RecommendBean>>changeResult())
                .subscribe(new Consumer<List<RecommendBean>>() {
                    @Override
                    public void accept(List<RecommendBean> recommendBeans) throws Exception {
                        baseCallBack.onSuccessful(recommendBeans);
                    }
                });
    }
}
