package com.example.myergedd.fragment.hear.chosen.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.ChosenBean;
import com.example.myergedd.bean.ChosenBeanBan;

import java.util.List;

public interface Chosen {
    public interface ChosenView{
        void onSuccess(List<ChosenBeanBan> cartoonBeanList);
        void onSuccessB(List<ChosenBean> chosenBeans);
        void onFailed(String error);
    }

    public interface ChosenModel {
        interface CallBack{
            void onSuccess(List<ChosenBeanBan> cartoonBeanList);
            void onSuccessB(List<ChosenBean> chosenBeans);
            void onFailed(String error);
        }
        void getChosen(CallBack callBack);
        void getChosenB(CallBack callBack);
    }

    public interface ChosenPresenter {
        void setChosenData();
        void setChosenDataB();
    }
}
