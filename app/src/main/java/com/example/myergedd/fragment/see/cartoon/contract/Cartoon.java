package com.example.myergedd.fragment.see.cartoon.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.see.CartoonBean;

import java.util.List;

public interface Cartoon {
    public interface CartoonView {
        void onSuccess(List<CartoonBean> cartoonBeanList);

        void onFailed(String error);
    }

    public interface CartoonModel {
        void getCartoon(BaseCallBack<List<CartoonBean>> listBaseCallBack);
    }

    public interface CartoonPresenter {
        void setCartoonData();
    }
}
