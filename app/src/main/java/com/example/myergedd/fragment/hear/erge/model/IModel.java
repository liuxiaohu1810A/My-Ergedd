package com.example.myergedd.fragment.hear.erge.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;
import com.example.myergedd.fragment.hear.erge.contract.Erge;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

import io.reactivex.functions.Consumer;

public class IModel implements Erge.ErgeModel {


    @Override
    public void getListenErgeData(final BaseCallBack<List<Listen_ErgeBean>> listBaseCallBack) {
        HttpManager.getInstance().getServer(ApiServier.class)
                .getListen_ErgeBeanData()
                .compose(RxJavaUtils.<BaseResponse<List<Listen_ErgeBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<Listen_ErgeBean>>changeResult())
                .subscribe(new Consumer<List<Listen_ErgeBean>>() {
                    @Override
                    public void accept(List<Listen_ErgeBean> listen_ergeBeans) throws Exception {
                        listBaseCallBack.onSuccessful(listen_ergeBeans);
                    }
                });
    }
}
