package com.example.myergedd.activity.searchsee;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.SearchSeeAlbumsBean;
import com.example.myergedd.bean.SearchSeeVideosBean;

import java.util.List;

public interface SearchSee {
    public interface SearchSeeView {
        void onAlbumsSuccessful(List<SearchSeeAlbumsBean> searchSeeBeans);

        void onVideoSuccessful(List<SearchSeeVideosBean> searchSeeBeans);

        void onFailed(String error);
    }

    public interface SearchSeeModel {
        void getDataAlbumsSearch(String keyword, BaseCallBack<List<SearchSeeAlbumsBean>> callBack);

        void getDataVideoSearch(String keyword, BaseCallBack<List<SearchSeeVideosBean>> callBack);
    }

    public interface SearchSeePresenter {
        void setDataAlbumsSearch(String keyword);

        void setDataVideoSearch(String keyword);
    }
}
