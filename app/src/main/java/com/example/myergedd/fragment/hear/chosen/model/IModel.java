package com.example.myergedd.fragment.hear.chosen.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.hear.ChosenBean;
import com.example.myergedd.bean.hear.ChosenBeanBan;
import com.example.myergedd.fragment.hear.chosen.contract.Chosen;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements Chosen.ChosenModel {

    @Override
    public void getChosenB(final CallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getChosenData()
                .compose(RxJavaUtils.<BaseResponse<List<ChosenBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<ChosenBean>>changeResult())
                .subscribe(new BaseObserver<List<ChosenBean>>() {
                    @Override
                    public void onSuccessful(List<ChosenBean> data) {
                        callBack .onSuccessB(data);
                    }

                    @Override
                    public void onFailed(String error) {
                        callBack.onFailed(error);
                    }
                });
    }

    @Override
    public void getChosen(final CallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getChosenBanData()
                .compose(RxJavaUtils.<BaseResponse<List<ChosenBeanBan>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<ChosenBeanBan>>changeResult())
                .subscribe(new BaseObserver<List<ChosenBeanBan>>() {
                    @Override
                    public void onSuccessful(List<ChosenBeanBan> data) {
                        callBack.onSuccess(data);
                    }

                    @Override
                    public void onFailed(String error) {
                        callBack.onFailed(error);
                    }
                });
    }
}
