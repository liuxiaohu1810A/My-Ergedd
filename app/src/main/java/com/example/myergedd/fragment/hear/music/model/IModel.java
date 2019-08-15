package com.example.myergedd.fragment.hear.music.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.fragment.hear.music.contract.Music;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements Music.MusicModel {
    @Override
    public void getMusic(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getMusicData()
                .compose(RxJavaUtils.<BaseResponse<List<MusicBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<MusicBean>>changeResult())
                .subscribe(new BaseObserver<List<MusicBean>>() {
                    @Override
                    public void onSuccessful(List<MusicBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
