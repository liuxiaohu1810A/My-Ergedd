package com.example.myergedd.activity.commonsee;

import android.util.Log;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class CommonSeeModel implements CommonSee.CommonSeeModel {
    @Override
    public void getCommonData(int id, final BaseCallBack<List<CommonSeeBean>> callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getDataCommon(id)
                .compose(RxJavaUtils.<BaseResponse<List<CommonSeeBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<CommonSeeBean>>changeResult())
                .subscribe(new BaseObserver<List<CommonSeeBean>>() {
                    @Override
                    public void onSuccessful(List<CommonSeeBean> data) {
                        if (data != null) {
                            if (data.size() > 0) {
                                callBack.onSuccessful(data);
                                Log.e("common", "onSuccessful: " + data.size());
                            }
                        }
                    }

                    @Override
                    public void onFailed(String error) {
                        if (error != null) {
                            callBack.onFiled(error);
                        }
                    }
                });
    }
}
