package com.example.myergedd.fragment.see.chosen.cartoon.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.fragment.see.chosen.cartoon.contract.Cartoon;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements Cartoon.CartoonModel {
    @Override
    public void getCartoon(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getCartoonData()
                .compose(RxJavaUtils.<BaseResponse<List<CartoonBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<CartoonBean>>changeResult())
                .subscribe(new BaseObserver<List<CartoonBean>>() {
                    @Override
                    public void onSuccessful(List<CartoonBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
