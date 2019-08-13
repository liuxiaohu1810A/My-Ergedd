package com.example.myergedd.fragment.hear.english.model;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.english.contract.HearEnglish;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class IModel implements HearEnglish.HearEnglishModel {
    @Override
    public void getHearEnglish(final BaseCallBack callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getHearEnglishData()
                .compose(RxJavaUtils.<BaseResponse<List<HearEnglishBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<HearEnglishBean>>changeResult())
                .subscribe(new BaseObserver<List<HearEnglishBean>>() {
                    @Override
                    public void onSuccessful(List<HearEnglishBean> data) {
                        callBack.onSuccessful(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
    }
}
