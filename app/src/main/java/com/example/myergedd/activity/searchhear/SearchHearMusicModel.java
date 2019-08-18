package com.example.myergedd.activity.searchhear;

import android.util.Log;

import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseRecordResponse;
import com.example.myergedd.bean.SearchHearHotBean;
import com.example.myergedd.bean.SearchHearMusicBean;
import com.example.myergedd.http.HttpManagerPost;
import com.example.myergedd.utils.RxJavaUtils;

public class SearchHearMusicModel implements SearchMusicHear.SearchMusicHearModel {
    @Override
    public void getSearchMusic(String keywork, final BaseCallBack<SearchHearMusicBean> callBack) {
        HttpManagerPost.getInstance().getServer(ApiServier.class).getDataHearMusicSearch(keywork)
                .compose(RxJavaUtils.<BaseRecordResponse<SearchHearMusicBean>>rxScheduleThread())
                .compose(RxJavaUtils.<SearchHearMusicBean>changeResultPost())
                .subscribe(new BaseObserver<SearchHearMusicBean>() {
                    @Override
                    public void onSuccessful(SearchHearMusicBean data) {
                        if (data != null) {
                            if (data.getAudios().size() > 0) {
                                callBack.onSuccessful(data);
                                Log.e("searchhearmusic", "onSuccessful: " + data.getAudios().toString());
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
    public void getSearchHot(int offset, final BaseCallBack<SearchHearHotBean> callBack) {
        HttpManagerPost.getInstance().getServer(ApiServier.class).getDataHearHotSearch(offset)
                .compose(RxJavaUtils.<BaseRecordResponse<SearchHearHotBean>>rxScheduleThread())
                .compose(RxJavaUtils.<SearchHearHotBean>changeResultPost())
                .subscribe(new BaseObserver<SearchHearHotBean>() {
                    @Override
                    public void onSuccessful(SearchHearHotBean data) {
                        if (data != null) {
                            if (data.getKeywords().size() > 0) {
                                callBack.onSuccessful(data);
                                Log.e("searchhearhot", "onSuccessful: " + data.getKeywords().toString());
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
