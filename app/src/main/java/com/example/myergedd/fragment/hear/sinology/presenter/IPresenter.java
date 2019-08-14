package com.example.myergedd.fragment.hear.sinology.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.bean.SinologyBean;
import com.example.myergedd.fragment.hear.sinology.contract.Sinology;
import com.example.myergedd.fragment.hear.sinology.model.IModel;

import java.util.List;

public class IPresenter<V extends Sinology.SinologyView> extends BasePresenter<V> implements Sinology.SinologyPresenter {
    private Sinology.SinologyModel model = new IModel();

    @Override
    public void setSinologyData() {
        if (mView != null) {
            model.getSinology(new BaseCallBack<List<SinologyBean>>() {
                @Override
                public void onSuccessful(List<SinologyBean> sinologyBeanList) {
                    mView.onSuccess(sinologyBeanList);
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
