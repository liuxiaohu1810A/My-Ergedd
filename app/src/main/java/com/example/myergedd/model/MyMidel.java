package com.example.myergedd.model;

import android.util.Log;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.SongBean;
import com.example.myergedd.contact.MyContact;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.HttpUtils;
import com.example.myergedd.utils.RxJavaUtils;
import com.squareup.haha.perflib.Main;

import java.util.List;

import io.reactivex.functions.Consumer;

public class MyMidel implements MyContact.MainModel {
    @Override
    public void getDataM(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getEg()
                .compose(RxJavaUtils.<List<SongBean>>changeResult())
                .compose(RxJavaUtils.<List<SongBean>>rxScheduleThread())
                .subscribe(new Consumer<List<SongBean>>() {
                    @Override
                    public void accept(List<SongBean> songBeans) throws Exception {
                        callBack.onSuccessful(songBeans);
                        Log.e("ds", "accept: " + songBeans.size());
                    }
                });
    }

}
