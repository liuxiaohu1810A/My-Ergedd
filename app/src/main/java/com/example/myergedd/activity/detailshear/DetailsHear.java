package com.example.myergedd.activity.detailshear;

import com.example.myergedd.base.BaseCallBack;

import java.util.List;

public interface DetailsHear {
    public interface DetailsHearView {
        void onSuccessful(DetailsHearBean detailsHearBeans);

        void onFailed(String error);
    }

    public interface DetailsHearModel {
        void getDetailsData(int id, BaseCallBack<DetailsHearBean> callBack);
    }

    public interface DetailsHearPresenter {
        void setDetailsData(int id);
    }
}
