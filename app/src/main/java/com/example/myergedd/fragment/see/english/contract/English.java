package com.example.myergedd.fragment.see.english.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.see.EnglishBean;

import java.util.List;

public interface English {
    public interface EnglishView {
        void onSuccess(List<EnglishBean> englishBeanList);
//        EnglishBean
        void onFailed(String error);
    }

    public interface EnglishModel {
        void getEnglish(BaseCallBack<List<EnglishBean>> englishCallBack);
    }

    public interface EnglishPresenter {
        void setEnglishData();
    }
}
