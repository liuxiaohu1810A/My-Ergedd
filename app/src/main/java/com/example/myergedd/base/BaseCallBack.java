package com.example.myergedd.base;

public interface BaseCallBack<T> {
    void onSuccessful(T t);

    void onFiled(String error);
}
