package com.example.myergedd.fragment.see.erge.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.see.ErgeBean;
import com.example.myergedd.fragment.see.erge.contact.MyContact;
import com.example.myergedd.fragment.see.erge.contract.Erge;
import com.example.myergedd.fragment.see.erge.model.MyMidel;

import java.util.List;

public class IPresenter<V extends Erge.ErgeView> extends BasePresenter<V> implements Erge.ErgePresenter {
    private Erge.ErgeModel myModel = new MyMidel();

    @Override
    public void setErgeData(String album_id) {
        if (mView != null) {
            myModel.getErge(album_id,new BaseCallBack<List<ErgeBean>>() {
                @Override
                public void onSuccessful(List<ErgeBean> songBean) {
                    if (songBean != null) {
                        mView.onSuccess(songBean);
                    }
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
