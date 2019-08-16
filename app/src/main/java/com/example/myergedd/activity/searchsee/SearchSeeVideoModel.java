package com.example.myergedd.activity.searchsee;

import android.util.Log;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseRecordResponse;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.SearchSeeAlbumsBean;
import com.example.myergedd.bean.SearchSeeHotBean;
import com.example.myergedd.bean.SearchSeeVideosBean;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.http.HttpManagerPost;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.List;

public class SearchSeeVideoModel implements SearchVideoSee.SearchSeeModel {

    @Override
    public void getDataAlbumsSearch(String keyword, final BaseCallBack<List<SearchSeeAlbumsBean>> callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getDataAlbumsSearch(keyword)
                .compose(RxJavaUtils.<BaseResponse<List<SearchSeeAlbumsBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<SearchSeeAlbumsBean>>changeResult())
                .subscribe(new BaseObserver<List<SearchSeeAlbumsBean>>() {
                    @Override
                    public void onSuccessful(List<SearchSeeAlbumsBean> data) {
                        if (data != null) {
                            if (data.size() > 0) {
                                callBack.onSuccessful(data);
                                Log.e("SearchSeeAlbums", "onAlbumsSuccessful: " + data.toString());
                            }
                        }
                    }

                    @Override
                    public void onFailed(String error) {
                        if (error != null) {
                            callBack.onFiled(error);
                        }
                    }
                });
    }

    @Override
    public void getDataVideoSearch(String keyword, final BaseCallBack<List<SearchSeeVideosBean>> callBack) {
        HttpManager.getInstance().getServer(ApiServier.class).getDataVideoSearch(keyword)
                .compose(RxJavaUtils.<BaseResponse<List<SearchSeeVideosBean>>>rxScheduleThread())
                .compose(RxJavaUtils.<List<SearchSeeVideosBean>>changeResult())
                .subscribe(new BaseObserver<List<SearchSeeVideosBean>>() {
                    @Override
                    public void onSuccessful(List<SearchSeeVideosBean> data) {
                        if (data != null) {
                            if (data.size() > 0) {
                                callBack.onSuccessful(data);
                                Log.e("SearchSeeVideo", "onSuccessful: " + data.toString());
                            }
                        }
                    }

                    @Override
                    public void onFailed(String error) {
                        if (error != null) {
                            callBack.onFiled(error);
                        }
                    }
                });
    }

    @Override
    public void getDataHotSearch(final BaseCallBack<SearchSeeHotBean> callBack) {
        HttpManagerPost.getInstance().getServer(ApiServier.class).getDataHotSearch()
                .compose(RxJavaUtils.<BaseRecordResponse<SearchSeeHotBean>>rxScheduleThread())
                .compose(RxJavaUtils.<SearchSeeHotBean>changeResultPost())
                .subscribe(new BaseObserver<SearchSeeHotBean>() {
                    @Override
                    public void onSuccessful(SearchSeeHotBean data) {
                        if (data != null) {
                            if (data.getKeywords().size() > 0) {
                                callBack.onSuccessful(data);
                                Log.e("SearchSeeHot", "onSuccessful: " + data.toString());
                            }
                        }
                    }

                    @Override
                    public void onFailed(String error) {
                        if (error != null) {
                            callBack.onFiled(error);
                        }
                    }
                });
    }
}
