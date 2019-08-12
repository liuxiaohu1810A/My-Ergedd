package com.example.myergedd.fragment.see.erge.model;

import android.util.Log;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.ErgeBean;
import com.example.myergedd.fragment.see.erge.contact.MyContact;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

import io.reactivex.functions.Consumer;

public class MyMidel implements MyContact.MainModel {
    @Override
    public void getDataM(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getErgeData()
                .compose(RxJavaUtils.<List<ErgeBean>>changeResult())
                .compose(RxJavaUtils.<List<ErgeBean>>rxScheduleThread())
                .subscribe(new Consumer<List<ErgeBean>>() {
                    @Override
                    public void accept(List<ErgeBean> songBeans) throws Exception {
                        callBack.onSuccessful(songBeans);
                        Log.e("ds", "accept: " + songBeans.size());
                    }
                });
    }

}
