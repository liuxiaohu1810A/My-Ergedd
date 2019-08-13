package com.example.myergedd.fragment.hear.sinology.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.bean.SinologyBean;
import com.example.myergedd.fragment.hear.sinology.contract.Sinology;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements Sinology.SinologyModel {
    @Override
    public void getSinology(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getSinologyData()
                .compose(RxJavaUtils.<BaseResponse<List<SinologyBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<SinologyBean>>changeResult())
                .subscribe(new BaseObserver<List<SinologyBean>>() {
                    @Override
                    public void onSuccessful(List<SinologyBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
