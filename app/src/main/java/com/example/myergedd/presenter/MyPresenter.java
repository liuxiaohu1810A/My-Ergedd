package com.example.myergedd.presenter;

import android.util.Log;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.SongBean;
import com.example.myergedd.contact.MyContact;
import com.example.myergedd.model.MyMidel;
import com.squareup.haha.perflib.Main;

public class MyPresenter<V extends MyContact.MainView> extends BasePresenter<V> implements MyContact.MainPresenter {
    private MyContact.MainModel myModel = new MyMidel();

    @Override
    public void getDataP() {
        if (mView != null) {
            myModel.getDataM(new BaseCallBack<SongBean>() {
                @Override
                public void onSuccessful(SongBean songBean) {
                    if (songBean != null) {
                        mView.onSuccess(songBean);
                    }
                }

                @Override
                public void onFiled(String filed) {
                    if (filed != null) {
                        mView.onFail(filed);
                    }
                }
            });

        }
    }


}
