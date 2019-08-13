package com.example.myergedd.fragment.see.chosen;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.ChosenThree;
import com.example.myergedd.bean.ChosenTwoBean;

import java.util.List;

public interface Chosen {
    public interface ChosenView {
        void onSuccessTwo(List<ChosenTwoBean> twoBeans);

        void onSuccessThree(List<ChosenThree> threes);

        void onFailed(String error);
    }

    public interface ChosenModel {
        void getDateTwo(BaseCallBack<List<ChosenTwoBean>> twoBean);

        void getDataThree(BaseCallBack<List<ChosenThree>> threeBean);

    }

    public interface ChosenPresenter {
        void setDataTwo();

        void setDataThree();
    }
}
