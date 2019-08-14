package com.example.myergedd.fragment.hear.sinology.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.bean.SinologyBean;

import java.util.List;

public interface Sinology {
    public interface SinologyView {
        void onSuccess(List<SinologyBean> sinologyBeanList);

        void onFailed(String error);
    }

    public interface SinologyModel {
        void getSinology(BaseCallBack<List<SinologyBean>> sinologyCallBack);
    }

    public interface SinologyPresenter {
        void setSinologyData();
    }
}
