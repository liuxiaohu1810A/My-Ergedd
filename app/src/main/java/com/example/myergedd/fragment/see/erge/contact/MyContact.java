package com.example.myergedd.fragment.see.erge.contact;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.ErgeBean;

import java.util.List;

public interface MyContact {
    //View层
    interface MainView {
        void onSuccess(List<ErgeBean> songBean);

        void onFail(String fail);

    }

    //Presenter层
    interface MainPresenter {
        void getDataP();
    }

    //Model层
    interface MainModel {
        void getDataM(BaseCallBack<List<ErgeBean>> callBack);
    }
}
