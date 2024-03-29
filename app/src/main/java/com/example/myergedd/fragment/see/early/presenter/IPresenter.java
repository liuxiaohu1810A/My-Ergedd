package com.example.myergedd.fragment.see.early.presenter;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.EarlyBean;
import com.example.myergedd.fragment.see.early.contract.Early;
import com.example.myergedd.fragment.see.early.model.IModel;

import java.util.List;

public class IPresenter<V extends Early.EarlyView> extends BasePresenter<V> implements Early.EarlyPresenter {
    private Early.EarlyModel model = new IModel();

    @Override
    public void setEarlyData() {
        if (mView != null) {
            model.getEarly(new BaseCallBack<List<EarlyBean>>() {
                @Override
                public void onSuccessful(List<EarlyBean> earlyBeanList) {
                    mView.onSuccess(earlyBeanList);
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
