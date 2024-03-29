package com.example.myergedd.fragment.see.cartoon.presenter;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.fragment.see.cartoon.contract.Cartoon;
import com.example.myergedd.fragment.see.cartoon.model.IModel;

import java.util.List;

public class IPresenter<V extends Cartoon.CartoonView> extends BasePresenter<V> implements Cartoon.CartoonPresenter {
    private Cartoon.CartoonModel model = new IModel();

    @Override
    public void setCartoonData() {
        if (mView != null) {
            model.getCartoon(new BaseCallBack<List<CartoonBean>>() {
                @Override
                public void onSuccessful(List<CartoonBean> cartoonBeanList) {
                    mView.onSuccess(cartoonBeanList);
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
