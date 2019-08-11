package com.example.myergedd.fragment.early.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.EarlyBean;
import com.example.myergedd.bean.StoryBean;

import java.util.List;

public interface Early {
    public interface EarlyView {
        void onSuccess(List<EarlyBean> earlyBeanList);

        void onFailed(String error);
    }

    public interface EarlyModel {
        void getEarly(BaseCallBack<List<EarlyBean>> earlyCallBack);
    }

    public interface EarlyPresenter {
        void setEarlyData();
    }
}
