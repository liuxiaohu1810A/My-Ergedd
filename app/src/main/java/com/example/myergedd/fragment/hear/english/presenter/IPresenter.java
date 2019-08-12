package com.example.myergedd.fragment.hear.english.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.fragment.hear.english.contract.English;
import com.example.myergedd.fragment.hear.english.model.IModel;


import java.util.List;

public class IPresenter<V extends English.Listen_EnglishView> extends BasePresenter<V> implements English.Listen_EnglishPresenter {
    private English.Listen_EnglishModel model = new IModel();

    @Override
    public void getListen_EnglishData() {
        if (mView != null){
            model.getListen_EnglishData(new BaseCallBack<List<Listen_EnglishBean>>() {
                @Override
                public void onSuccessful(List<Listen_EnglishBean> listen_englishBeans) {
                    mView.OnSuccess(listen_englishBeans);
                }

                @Override
                public void onFiled() {

                }
            });
        }
    }
}
