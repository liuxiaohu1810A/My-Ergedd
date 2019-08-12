package com.example.myergedd.fragment.hear.english.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.english.contract.HearEnglish;
import com.example.myergedd.fragment.hear.english.model.IModel;

import java.util.List;

public class IPresenter<V extends HearEnglish.HearEnglishView> extends BasePresenter<V> implements HearEnglish.HearEnglishPresenter {
    private HearEnglish.HearEnglishModel model = new IModel();

    @Override
    public void setHearEnglishData() {
        if (mView != null) {
            model.getHearEnglish(new BaseCallBack<List<HearEnglishBean>>() {
                @Override
                public void onSuccessful(List<HearEnglishBean> hearEnglishBeanList) {
                    mView.onSuccess(hearEnglishBeanList);
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
