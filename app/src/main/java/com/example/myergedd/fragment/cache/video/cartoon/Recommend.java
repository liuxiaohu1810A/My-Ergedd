package com.example.myergedd.fragment.cache.video.cartoon;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.RecommendBean;

import java.util.List;

public interface Recommend {

    interface RecommendView{
        void OnSuccess(List<RecommendBean> recommendBeans);
        void OnFailed(String error);
    }

    interface RecommendModel{
        void getRecommendData(BaseCallBack<List<RecommendBean>> baseCallBack);
    }

    interface RecommendPresent{
        void getRecommendData();
    }
}
