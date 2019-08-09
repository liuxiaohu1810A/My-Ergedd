package com.example.myergedd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.app.Globle;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.base.SimpleActivity;
import com.example.myergedd.bean.DongHua;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;
import com.example.myergedd.utils.ToastUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends SimpleActivity {
    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initMvp() {
        HttpManager.getInstance().getServer(ApiServier.class).get()
                .compose(RxJavaUtils.<BaseResponse<List<DongHua>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<DongHua>>changeResult())
                .subscribe(new BaseObserver<List<DongHua>>() {
                    @Override
                    public void onSuccessful(List<DongHua> data) {
                        if (data != null) {
                            Log.e("data", "onSuccessful: " + data.toString());
                        }
                    }

                    @Override
                    public void onFailed(String error) {
                        if (error != null) {
                            ToastUtils.ShowToast(MainActivity.this, error);
                        }
                    }
                });
    }
}
