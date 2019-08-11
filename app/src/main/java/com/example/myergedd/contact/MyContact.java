package com.example.myergedd.contact;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.SongBean;


import java.util.List;

public interface MyContact {
    //View层
    interface MainView {
        void onSuccess(SongBean songBean);

        void onFail(String fail);


    }

    //Presenter层
    interface MainPresenter {
        void getDataP(int page);
    }

    //Model层
    interface MainModel {


        void getDataM(BaseCallBack callBack);

        void getDataList( BaseCallBack callBack);

    }
}
