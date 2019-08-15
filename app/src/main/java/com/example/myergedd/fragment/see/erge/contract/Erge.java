package com.example.myergedd.fragment.see.erge.contract;


import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.see.ErgeBean;

import java.util.List;

public interface Erge {
    public interface ErgeView {
        void onSuccess(List<ErgeBean> ergeBeanList);
//        HearEnglishBean
        void onFailed(String error);
    }

    public interface ErgeModel {
        void getErge(String album_id,BaseCallBack<List<ErgeBean>> ergeCallBack);
    }

    public interface ErgePresenter {
        void setErgeData(String album_id);
    }
}
