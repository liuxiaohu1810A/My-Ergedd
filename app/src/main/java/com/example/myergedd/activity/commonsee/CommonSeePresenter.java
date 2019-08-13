package com.example.myergedd.activity.commonsee;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;

import java.util.List;

public class CommonSeePresenter<V extends CommonSee.CommonSeeView> extends BasePresenter<V> implements CommonSee.CommonSeePresenter {
    private CommonSee.CommonSeeModel mModel = new CommonSeeModel();

    @Override
    public void setCommonData(int id) {
        if (mView != null) {
            mModel.getCommonData(id, new BaseCallBack<List<CommonSeeBean>>() {
                @Override
                public void onSuccessful(List<CommonSeeBean> commonSeeBeans) {
                    if (commonSeeBeans != null) {
                        if (commonSeeBeans.size() > 0) {
                            mView.onSuccessful(commonSeeBeans);
                        }
                    }
                }

                @Override
                public void onFiled(String error) {
                    if (error != null) {
                        mView.onFailed(error);
                    }
                }
            });
        }
    }
}
