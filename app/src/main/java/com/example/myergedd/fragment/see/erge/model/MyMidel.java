package com.example.myergedd.fragment.see.erge.model;

import android.util.Log;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.see.ErgeBean;
import com.example.myergedd.fragment.see.erge.contact.MyContact;
import com.example.myergedd.fragment.see.erge.contract.Erge;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

import io.reactivex.functions.Consumer;

public class MyMidel implements Erge.ErgeModel {
    @Override
    public void getErge(String album_id,final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getErgeData(album_id)
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
