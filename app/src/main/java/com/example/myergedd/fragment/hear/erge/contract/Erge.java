package com.example.myergedd.fragment.hear.erge.contract;

import com.example.myergedd.base.BaseCallBack;

import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;

import java.util.List;

public interface Erge {

    public interface ErgeView{

        void OnSuccess(List<Listen_ErgeBean> listen_ergeBeans);
        void OnFailed(String error);
    }
    public interface ErgeModel{
        void getListenErgeData(BaseCallBack<List<Listen_ErgeBean>> listBaseCallBack);
    }

    public interface ErgePresenter{
        void getListenErgeData();
    }

}
