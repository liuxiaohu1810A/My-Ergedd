package com.example.myergedd.fragment.see.erge.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.ErgeBean;
import com.example.myergedd.fragment.see.erge.contact.MyContact;
import com.example.myergedd.fragment.see.erge.model.MyMidel;

import java.util.List;

public class MyPresenter<V extends MyContact.MainView> extends BasePresenter<V> implements MyContact.MainPresenter {
    private MyContact.MainModel myModel = new MyMidel();

    @Override
    public void getDataP() {
        if (mView != null) {
            myModel.getDataM(new BaseCallBack<List<ErgeBean>>() {
                @Override
                public void onSuccessful(List<ErgeBean> songBean) {
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
