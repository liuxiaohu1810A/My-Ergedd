package com.example.myergedd.activity.searchhear;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.SearchHearHotBean;
import com.example.myergedd.bean.SearchHearMusicBean;

public interface SearchMusicHear {
    public interface SearchMusicHearView {
        void onSearchMusicSuccessful(SearchHearMusicBean hearMusicBean);

        void onSearchHotSuccessful(SearchHearHotBean hearHotBean);

        void onSearchMusicFiled(String error);
    }

    public interface SearchMusicHearPresenter {
        void setSearchMusic(String keywork);

        void setSearchHot(int offset);
    }

    public interface SearchMusicHearModel {
        void getSearchMusic(String keywork, BaseCallBack<SearchHearMusicBean> callBack);

        void getSearchHot(int offset, BaseCallBack<SearchHearHotBean> callBack);
    }
}
