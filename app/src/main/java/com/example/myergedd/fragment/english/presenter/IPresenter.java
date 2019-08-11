package com.example.myergedd.fragment.english.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.StoryBean;
import com.example.myergedd.fragment.english.contract.English;
import com.example.myergedd.fragment.english.model.IModel;

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
                public void onFiled() {

                }
            });
        }
    }
}
