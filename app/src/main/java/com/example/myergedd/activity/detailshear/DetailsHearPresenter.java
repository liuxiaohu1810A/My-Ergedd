package com.example.myergedd.activity.detailshear;

import com.example.myergedd.activity.commonsee.CommonSee;
import com.example.myergedd.activity.commonsee.CommonSeeBean;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;

import java.util.List;

public class DetailsHearPresenter<V extends DetailsHear.DetailsHearView> extends BasePresenter<V> implements DetailsHear.DetailsHearPresenter {
    private DetailsHear.DetailsHearModel mModel = new DetailsHearModel();
    @Override
    public void setDetailsData(int id) {
        if (mView != null) {
            mModel.getDetailsData(id, new BaseCallBack< DetailsHearBean >() {
                @Override
                public void onSuccessful(DetailsHearBean detailsHearBeans) {
                    if (detailsHearBeans != null) {
                        if (detailsHearBeans.getAudios().size() > 0) {
                            mView.onSuccessful(detailsHearBeans);
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
