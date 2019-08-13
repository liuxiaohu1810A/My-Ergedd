package com.example.myergedd.fragment.see.synthesize.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.SynthesizeBean;
import com.example.myergedd.fragment.see.synthesize.contract.Synthesize;
import com.example.myergedd.fragment.see.synthesize.model.IModel;

import java.util.List;

public class IPresenter<V extends Synthesize.SynthesizeView> extends BasePresenter<V> implements Synthesize.SynthesizePresenter {
    private Synthesize.SynthesizeModel model = new IModel();

    @Override
    public void setSynthesizeData() {
        if (mView != null) {
            model.getSynthesize(new BaseCallBack<List<SynthesizeBean>>() {
                @Override
                public void onSuccessful(List<SynthesizeBean> synthesizeBeanList) {
                    mView.onSuccess(synthesizeBeanList);
                }

                @Override
                public void onFiled(String error) {
                    mView.onFailed(error);
                }
            });
        }
    }
}
