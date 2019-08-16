package com.example.myergedd.base;

import java.io.Serializable;

public class BaseRecordResponse<T> implements Serializable {
    int status;
    T record;

    public boolean isSuccess() {
        return status >= 200 && status <= 299;
    }

    public T getData() {
        return record;
    }
}
