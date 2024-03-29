package com.example.myergedd.utils;

import com.example.myergedd.base.BaseRecordResponse;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.http.HttpErrorCode;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxJavaUtils {
    //简化线程切换的代码
    public static <T> ObservableTransformer<T, T> rxScheduleThread() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    //将数据转换成我们想要的数据
    public static <T> ObservableTransformer<BaseResponse<T>, T> changeResult() {
        return new ObservableTransformer<BaseResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(final BaseResponse<T> tBaseResponse) throws Exception {
                        if (tBaseResponse.isSuccess()) {
                            return Observable.create(new ObservableOnSubscribe<T>() {
                                @Override
                                public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                                    try {
                                        emitter.onNext(tBaseResponse.getData());
                                        emitter.onComplete();
                                    } catch (Exception e) {
                                        emitter.onError(e);
                                    }
                                }
                            });
                        } else {
                            return Observable.error(new HttpErrorCode(tBaseResponse.getMessage()));
                        }
                    }
                });
            }
        };
    }

    //将数据转换成我们想要的数据
    public static <T> ObservableTransformer<BaseRecordResponse<T>, T> changeResultPost() {
        return new ObservableTransformer<BaseRecordResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseRecordResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseRecordResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(final BaseRecordResponse<T> tBaseResponse) throws Exception {
                        if (tBaseResponse.isSuccess()) {
                            return Observable.create(new ObservableOnSubscribe<T>() {
                                @Override
                                public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                                    try {
                                        emitter.onNext(tBaseResponse.getData());
                                        emitter.onComplete();
                                    } catch (Exception e) {
                                        emitter.onError(e);
                                    }
                                }
                            });
                        } else {
                            return Observable.error(new HttpErrorCode("失败了哦···"));
                        }
                    }
                });
            }
        };
    }
}