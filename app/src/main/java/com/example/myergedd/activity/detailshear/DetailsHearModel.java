package com.example.myergedd.activity.detailshear;

import android.util.Log;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseRecordResponse;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.http.HttpManagerPost;
import com.example.myergedd.utils.RxJavaUtils;


public class DetailsHearModel implements DetailsHear.DetailsHearModel {
    private static final String TAG = "DetailsHearModel";
    @Override
    public void getDetailsData(int id, final BaseCallBack<DetailsHearBean> callBack) {
        HttpManagerPost.getInstance().getServer(ApiServier.class).getRequestAllAudioByPlayListId(id,0,300)
                .compose(RxJavaUtils.<BaseRecordResponse<DetailsHearBean>>rxScheduleThread())
                .compose(RxJavaUtils.<DetailsHearBean>changeResultPost())
                .subscribe(new BaseObserver<DetailsHearBean> () {
                    @Override
                    public void onSuccessful(DetailsHearBean data) {
                        if (data != null) {
                            if (data.getAudios().size()> 0) {
                                callBack.onSuccessful(data);
                                Log.d(TAG, "onSuccessful: "+data.getAudios().toString());
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
