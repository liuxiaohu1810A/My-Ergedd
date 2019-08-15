package com.example.myergedd.fragment.cache.video.presenter;

import android.support.v7.widget.RecyclerView;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.RecommendBean;
import com.example.myergedd.fragment.cache.video.cartoon.Recommend;
import com.example.myergedd.fragment.cache.video.model.IModel;

import java.util.List;

public class IPresenter<V extends Recommend.RecommendView> extends BasePresenter<V> implements Recommend.RecommendPresent {

    private Recommend.RecommendModel model = new IModel();

    @Override
    public void getRecommendData() {
        model.getRecommendData(new BaseCallBack<List<RecommendBean>>() {
            @Override
            public void onSuccessful(List<RecommendBean> recommendBeans) {
                mView.OnSuccess(recommendBeans);
            }

            @Override
            public void onFiled(String filed) {
                if (filed != null){
                    mView.OnFailed(filed);
                }
            }
        });
    }
}
