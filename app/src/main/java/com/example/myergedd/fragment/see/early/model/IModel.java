package com.example.myergedd.fragment.see.early.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.EarlyBean;
import com.example.myergedd.fragment.see.early.contract.Early;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements Early.EarlyModel {
    @Override
    public void getEarly(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getEarlyData()
                .compose(RxJavaUtils.<BaseResponse<List<EarlyBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<EarlyBean>>changeResult())
                .subscribe(new BaseObserver<List<EarlyBean>>() {
                    @Override
                    public void onSuccessful(List<EarlyBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
