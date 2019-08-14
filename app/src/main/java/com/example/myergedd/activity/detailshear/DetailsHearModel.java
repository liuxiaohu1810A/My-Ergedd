package com.example.myergedd.activity.detailshear;

import android.util.Log;

import com.example.myergedd.R;
import com.example.myergedd.activity.commonsee.CommonSeeBean;
import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseRecordResponse;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class DetailsHearModel implements DetailsHear.DetailsHearModel {
    @Override
    public void getDetailsData(int id, final BaseCallBack<DetailsHearBean> callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getRequestAllAudioByPlayListId(id)
                .compose(RxJavaUtils.<BaseRecordResponse<DetailsHearBean>>rxScheduleThread())
                .compose(RxJavaUtils.<DetailsHearBean>changeResultPost())
                .subscribe(new BaseObserver<DetailsHearBean> () {
                    @Override
                    public void onSuccessful( DetailsHearBean  data) {
                        if (data != null) {
                            if (data.getAudios().size()> 0) {
                                callBack.onSuccessful(data);
                                Log.e("common", "onAlbumsSuccessful: " + data.getAudios().size());
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
