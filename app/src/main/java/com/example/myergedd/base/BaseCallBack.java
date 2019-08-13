package com.example.myergedd.base;

import com.example.myergedd.bean.hear.ChosenBean;

import java.util.List;

public interface BaseCallBack<T> {
    void onSuccessful(T t);
  // void onSuccessB(T chosenBeans);

    void onFiled(String filed);


}
