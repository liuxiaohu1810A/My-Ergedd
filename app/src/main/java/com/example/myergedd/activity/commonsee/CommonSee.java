package com.example.myergedd.activity.commonsee;

import com.example.myergedd.base.BaseCallBack;

import java.util.List;

public interface CommonSee {
    public interface CommonSeeView {
        void onSuccessful(List<CommonSeeBean> commonSeeBeans);

        void onFailed(String error);
    }

    public interface CommonSeeModel {
        void getCommonData(int id, BaseCallBack<List<CommonSeeBean>> callBack);
    }

    public interface CommonSeePresenter {
        void setCommonData(int id);
    }
}
