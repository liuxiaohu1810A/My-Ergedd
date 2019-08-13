package com.example.myergedd.fragment.hear.chosen.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.hear.ChosenBean;
import com.example.myergedd.bean.hear.ChosenBeanBan;
import com.example.myergedd.fragment.hear.chosen.contract.Chosen;
import com.example.myergedd.fragment.hear.chosen.model.IModel;

import java.util.List;

public class IPresenter<V extends Chosen.ChosenView> extends BasePresenter<V> implements Chosen.ChosenPresenter,Chosen.ChosenModel.CallBack {
    private Chosen.ChosenModel model = new IModel();


    @Override
    public void setChosenData() {
        if (mView!=null){
            model.getChosen(this);
        }
    }

    @Override
    public void setChosenDataB() {
        if (mView!=null){
            model.getChosenB(this);
        }
    }


    @Override
    public void onSuccess(List<ChosenBeanBan> cartoonBeanList) {
           mView.onSuccess(cartoonBeanList);
    }

    @Override
    public void onSuccessB(List<ChosenBean> chosenBeans) {
        mView.onSuccessB(chosenBeans);
    }

    @Override
    public void onFailed(String error) {
         mView.onFailed(error);
    }
}