package com.example.myergedd.activity.searchsee;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.SearchSeeAlbumsBean;
import com.example.myergedd.bean.SearchSeeHotBean;
import com.example.myergedd.bean.SearchSeeVideosBean;

import java.util.List;

public class SearchSeePresenter<V extends SearchSee.SearchSeeView> extends BasePresenter<V> implements SearchSee.SearchSeePresenter {
    private SearchSee.SearchSeeModel mModel = new SearchSeeModel();

    @Override
    public void setDataAlbumsSearch(String keyword) {
        if (mView != null) {
            mModel.getDataAlbumsSearch(keyword, new BaseCallBack<List<SearchSeeAlbumsBean>>() {
                @Override
                public void onSuccessful(List<SearchSeeAlbumsBean> searchSeeBeans) {
                    if (searchSeeBeans != null) {
                        if (searchSeeBeans.size() > 0) {
                            mView.onAlbumsSuccessful(searchSeeBeans);
                        }
                    }
                }

                @Override
                public void onFiled(String filed) {
                    if (filed != null) {
                        mView.onFailed(filed);
                    }
                }
            });
        }
    }

    @Override
    public void setDataVideoSearch(String keyword) {
        if (mView != null) {
            mModel.getDataVideoSearch(keyword, new BaseCallBack<List<SearchSeeVideosBean>>() {
                @Override
                public void onSuccessful(List<SearchSeeVideosBean> searchSeeVideosBeans) {
                    if (searchSeeVideosBeans != null) {
                        if (searchSeeVideosBeans.size() > 0) {
                            mView.onVideoSuccessful(searchSeeVideosBeans);
                        }
                    }
                }

                @Override
                public void onFiled(String filed) {
                    if (filed != null) {
                        mView.onFailed(filed);
                    }
                }
            });
        }
    }

    @Override
    public void setDataHotSearch() {
        if (mView != null) {
            mModel.getDataHotSearch(new BaseCallBack<SearchSeeHotBean>() {
                @Override
                public void onSuccessful(SearchSeeHotBean seeHotBean) {
                    if (seeHotBean != null) {
                        if (seeHotBean.getKeywords().size() > 0) {
                            mView.onHotSuceessful(seeHotBean);
                        }
                    }
                }

                @Override
                public void onFiled(String filed) {
                    if (filed != null) {
                        mView.onFailed(filed);
                    }
                }
            });
        }
    }
}
