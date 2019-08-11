package com.example.myergedd.base;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends SimpleFragment {
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
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter!=null){
            mPresenter.destroy();
        }
    }
}
