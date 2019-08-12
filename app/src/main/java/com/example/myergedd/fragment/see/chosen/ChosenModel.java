package com.example.myergedd.fragment.see.chosen;

import android.util.Log;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.ChosenThree;
import com.example.myergedd.bean.ChosenTwoBean;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class ChosenModel implements Chosen.ChosenModel {
    @Override
    public void getDateTwo(final BaseCallBack<List<ChosenTwoBean>> twoBean) {
        HttpManager.getInstance().getServer(ApiServier.class).getDataChosenTwo()
                .compose(RxJavaUtils.<BaseResponse<List<ChosenTwoBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<ChosenTwoBean>>changeResult())
                .subscribe(new BaseObserver<List<ChosenTwoBean>>() {
                    @Override
                    public void onSuccessful(List<ChosenTwoBean> data) {
                        if (data.size() > 0) {
                            twoBean.onSuccessful(data);
                            Log.e("jingxuan", "onSuccessful:2 " + data.size());
                        }
                    }

                    @Override
                    public void onFailed(String error) {
                        if (error != null) {
                            twoBean.onFiled(error);
                        }
                    }
                });
    }

    @Override
    public void getDataThree(final BaseCallBack<List<ChosenThree>> threeBean) {
        HttpManager.getInstance().getServer(ApiServier.class).getDataChosenThree()
                .compose(RxJavaUtils.<BaseResponse<List<ChosenThree>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<ChosenThree>>changeResult())
                .subscribe(new BaseObserver<List<ChosenThree>>() {
                    @Override
                    public void onSuccessful(List<ChosenThree> data) {
                        if (data.size() > 0) {
                            threeBean.onSuccessful(data);
                            Log.e("jingxuan", "onSuccessful:3 " + data.size());
                        }
                    }

                    @Override
                    public void onFailed(String error) {
                        if (error != null) {
                            threeBean.onFiled(error);
                        }
                    }
                });
    }
}
