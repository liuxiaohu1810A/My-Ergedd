package com.example.myergedd.fragment.see.chosen;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.see.ChosenThree;
import com.example.myergedd.bean.see.ChosenTwoBean;

import java.util.List;

public class ChosenPresenter<V extends Chosen.ChosenView> extends BasePresenter<V> implements Chosen.ChosenPresenter {
    private Chosen.ChosenModel mModel = new ChosenModel();

    @Override
    public void setDataTwo() {
        if (mView != null) {
            mModel.getDateTwo(new BaseCallBack<List<ChosenTwoBean>>() {
                @Override
                public void onSuccessful(List<ChosenTwoBean> twoBeans) {
                    if (twoBeans.size() > 0) {
                        mView.onSuccessTwo(twoBeans);
                    }
                }

                @Override
                public void onFiled(String error) {
                    if (error != null) {
                        mView.onFailed(error);
                    }
                }

            });
        }
    }
    @Override
    public void setDataThree() {
        if (mView != null) {
            mModel.getDataThree(new BaseCallBack<List<ChosenThree>>() {
                @Override
                public void onSuccessful(List<ChosenThree> threes) {
                    if (threes.size() > 0) {
                        mView.onSuccessThree(threes);
                    }
                }

                @Override
                public void onFiled(String error) {
                    if (error != null) {
                        mView.onFailed(error);
                    }
                }
            });
        }
    }
}
