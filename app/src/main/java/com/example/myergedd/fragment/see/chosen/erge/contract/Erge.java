package com.example.myergedd.fragment.see.chosen.erge.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.ErgeBean;

import java.util.List;

public interface Erge {
    public interface ErgeView {
        void onSuccess(List<ErgeBean> ergeBeanList);
//        HearEnglishBean
        void onFailed(String error);
    }

    public interface ErgeModel {
        void getErge(BaseCallBack<List<ErgeBean>> ergeCallBack);
    }

    public interface ErgePresenter {
        void setErgeData();
    }
}
