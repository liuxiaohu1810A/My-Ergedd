package com.example.myergedd.activity.searchhear;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.SearchHearHotBean;
import com.example.myergedd.bean.SearchHearMusicBean;

public class SearchHearMusicPresenter<V extends SearchMusicHear.SearchMusicHearView> extends BasePresenter<V> implements SearchMusicHear.SearchMusicHearPresenter {
    private SearchMusicHear.SearchMusicHearModel mModel = new SearchHearMusicModel();

    @Override
    public void setSearchMusic(String keywork) {
        if (mView != null) {
            mModel.getSearchMusic(keywork, new BaseCallBack<SearchHearMusicBean>() {
                @Override
                public void onSuccessful(SearchHearMusicBean hearMusicBean) {
                    if (hearMusicBean != null) {
                        if (hearMusicBean.getAudios().size() > 0) {
                            mView.onSearchMusicSuccessful(hearMusicBean);
                        }
                    }
                }

                @Override
                public void onFiled(String filed) {
                    if (filed != null) {
                        mView.onSearchMusicFiled(filed);
                    }
                }
            });
        }
    }

    @Override
    public void setSearchHot(int offset) {
        if (mView != null) {
            mModel.getSearchHot(offset, new BaseCallBack<SearchHearHotBean>() {
                @Override
                public void onSuccessful(SearchHearHotBean hearHotBean) {
                    if (hearHotBean != null) {
                        if (hearHotBean.getKeywords().size() > 0) {
                            mView.onSearchHotSuccessful(hearHotBean);
                        }
                    }
                }

                @Override
                public void onFiled(String filed) {
                    if (filed != null) {
                        mView.onSearchMusicFiled(filed);
                    }
                }
            });
        }
    }
}
