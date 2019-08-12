package com.example.myergedd.fragment.see.chosen.synthesize.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.SynthesizeBean;
import com.example.myergedd.fragment.see.chosen.synthesize.contract.Synthesize;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements Synthesize.SynthesizeModel {
    @Override
    public void getSynthesize(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getSynthesizeData()
                .compose(RxJavaUtils.<BaseResponse<List<SynthesizeBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<SynthesizeBean>>changeResult())
                .subscribe(new BaseObserver<List<SynthesizeBean>>() {
                    @Override
                    public void onSuccessful(List<SynthesizeBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
