package com.example.myergedd.base;

import com.example.myergedd.http.HttpManager;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObserver<T> implements Observer<T> {
    //管理每次的网络请求
    CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void onComplete() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        mCompositeDisposable.add(d);
    }

    @Override
    public void onNext(T t) {
        onSuccessful(t);
    }

    @Override
    public void onError(Throwable e) {
        //请求网络失败
        if (e instanceof HttpException) {
            onFailed(e.getMessage());
        }
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    public abstract void onSuccessful(T data);

    public abstract void onFailed(String error);
}
