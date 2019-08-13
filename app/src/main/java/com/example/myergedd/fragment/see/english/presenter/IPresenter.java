package com.example.myergedd.fragment.see.english.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.see.EnglishBean;
import com.example.myergedd.fragment.see.english.contract.English;
import com.example.myergedd.fragment.see.english.model.IModel;

import java.util.List;

public class IPresenter<V extends English.EnglishView> extends BasePresenter<V> implements English.EnglishPresenter {
    private English.EnglishModel model = new IModel();

    @Override
    public void setEnglishData() {
        if (mView != null) {
            model.getEnglish(new BaseCallBack<List<EnglishBean>>() {
                @Override
                public void onSuccessful(List<EnglishBean> englishBeanList) {
                    mView.onSuccess(englishBeanList);
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
