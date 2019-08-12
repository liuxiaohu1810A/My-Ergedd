package com.example.myergedd.contact;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.SongBean;


import java.util.List;

public interface MyContact {
    //View层
    interface MainView<T> {
        void onSuccess(T songBean);

        void onFail(String fail);

    }

    //Presenter层
    interface MainPresenter {
        void getDataP();
    }

    //Model层
    interface MainModel {
        void getDataM(BaseCallBack<SongBean> callBack);
    }
}
