package com.example.myergedd.app;

import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.ChosenThree;
import com.example.myergedd.bean.ChosenTwoBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServier {
    String mUrl = "http://api.t.ergedd.com/api/v1/";

    /**
     * http://api.ergedd.com/api/v1/albums/home_recommended
     * 精选布局二
     *
     * @return
     */
    @GET("albums/home_recommended")
    Observable<BaseResponse<List<ChosenTwoBean>>> getDataChosenTwo();

    /**
     * http://api.ergedd.com/api/v1/home_items
     * 精选链表数据
     * @return
     */
    @GET("home_items")
    Observable<BaseResponse<List<ChosenThree>>> getDataChosenThree();
}
