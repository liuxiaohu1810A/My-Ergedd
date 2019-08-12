package com.example.myergedd.fragment.see.chosen.erge.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.ErgeBean;
import com.example.myergedd.fragment.see.chosen.erge.contract.Erge;
import com.example.myergedd.fragment.see.chosen.erge.model.IModel;

import java.util.List;

public class IPresenter<V extends Erge.ErgeView> extends BasePresenter<V> implements Erge.ErgePresenter {
    private Erge.ErgeModel model = new IModel();

    @Override
    public void setErgeData() {
        if (mView != null) {
            model.getErge(new BaseCallBack<List<ErgeBean>>() {
                @Override
                public void onSuccessful(List<ErgeBean> ergeBeanList) {
                    mView.onSuccess(ergeBeanList);
                }

                @Override
                public void onFiled(String filed) {
                    if (filed != null) {
                        mView.onFailed(filed);
                    }

                }
            });
        }
    }
}
