package com.example.myergedd.fragment.see.english.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.fragment.see.english.contract.English;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements English.EnglishModel {
    @Override
    public void getEnglish(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getEnglishData()
                .compose(RxJavaUtils.<BaseResponse<List<EnglishBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<EnglishBean>>changeResult())
                .subscribe(new BaseObserver<List<EnglishBean>>() {
                    @Override
                    public void onSuccessful(List<EnglishBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
