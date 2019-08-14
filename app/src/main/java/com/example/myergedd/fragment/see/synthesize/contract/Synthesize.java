package com.example.myergedd.fragment.see.synthesize.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.SynthesizeBean;

import java.util.List;

public interface Synthesize {
    public interface SynthesizeView {
        void onSuccess(List<SynthesizeBean> synthesizeBeanList);
        void onFailed(String error);
    }

    public interface SynthesizeModel {
        void getSynthesize(BaseCallBack<List<SynthesizeBean>> synthesizeCallBack);
    }

    public interface SynthesizePresenter {
        void setSynthesizeData();
    }
}
