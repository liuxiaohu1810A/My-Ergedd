package com.example.myergedd.app;

import com.example.myergedd.base.BaseResponse;


import com.example.myergedd.bean.hear.ChosenBean;
import com.example.myergedd.bean.hear.ChosenBeanBan;
import com.example.myergedd.bean.see.ChosenThree;
import com.example.myergedd.bean.see.ChosenTwoBean;

import com.example.myergedd.bean.see.CartoonBean;
import com.example.myergedd.bean.see.EarlyBean;
import com.example.myergedd.bean.see.EnglishBean;
import com.example.myergedd.bean.see.ErgeBean;
import com.example.myergedd.bean.see.StoryBean;
import com.example.myergedd.bean.see.SynthesizeBean;



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
     *
     * @return
     */
    @GET("home_items")
    Observable<BaseResponse<List<ChosenThree>>> getDataChosenThree();

    @GET("album_categories/4/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<CartoonBean>>> getCartoonData();

    @GET("album_categories/1/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<ErgeBean>>> getErgeData();

    @GET("album_categories/3/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<StoryBean>>> getStoryData();

    @GET("album_categories/6/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<EarlyBean>>> getEarlyData();

    @GET("album_categories/5/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<SynthesizeBean>>> getSynthesizeData();

    @GET("album_categories/2/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<EnglishBean>>> getEnglishData();


    @GET("audio_playlists/excellent?channel=original")
    Observable<BaseResponse<List<ChosenBeanBan>>> getChosenBanData();

    @GET("audio_categories")
    Observable<BaseResponse<List<ChosenBean>>> getChosenData();

}
