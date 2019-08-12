package com.example.myergedd.fragment.see.chosen.erge.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.ErgeBean;
import com.example.myergedd.fragment.see.chosen.erge.contract.Erge;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements Erge.ErgeModel {
    @Override
    public void getErge(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getErgeData()
                .compose(RxJavaUtils.<BaseResponse<List<ErgeBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<ErgeBean>>changeResult())
                .subscribe(new BaseObserver<List<ErgeBean>>() {
                    @Override
                    public void onSuccessful(List<ErgeBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
