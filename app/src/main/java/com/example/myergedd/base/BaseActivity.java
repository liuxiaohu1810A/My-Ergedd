package com.example.myergedd.base;

public abstract class BaseActivity<V, P extends BasePresenter<V>> extends SimpleActivity {
    protected P mPresenter;

    @Override
    protected void initMvp() {
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.addView((V) this);
        }
    }

    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.destroy();
        }
    }
}
