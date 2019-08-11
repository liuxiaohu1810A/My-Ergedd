package com.example.myergedd.base;

import java.lang.ref.WeakReference;

public class BasePresenter<V> {
    private WeakReference<V> mWeakReference;
    protected V mView;

    public void addView(V view) {
        mWeakReference = new WeakReference<>(view);
        mView = mWeakReference.get();
    }

    public void destroy() {
        if (mWeakReference != null) {
            mWeakReference.clear();
        }
    }
}
