package com.example.myergedd.fragment.hear.erge.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;
import com.example.myergedd.fragment.hear.erge.contract.Erge;
import com.example.myergedd.fragment.hear.erge.model.IModel;


import java.net.IDN;
import java.util.List;

public class IPresenter<V extends Erge.ErgeView> extends BasePresenter<V> implements Erge.ErgePresenter {

    private Erge.ErgeModel model = new IModel();

    @Override
    public void getListenErgeData() {
        if (mView !=  null){
            model.getListenErgeData(new BaseCallBack<List<Listen_ErgeBean>>() {
                @Override
                public void onSuccessful(List<Listen_ErgeBean> listen_ergeBeans) {
                    mView.OnSuccess(listen_ergeBeans);
                }

                @Override
                public void onFiled(String filed) {

                }

            });
        }
    }
}
