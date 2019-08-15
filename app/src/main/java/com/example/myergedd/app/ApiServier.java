package com.example.myergedd.app;

import com.example.myergedd.activity.commonsee.CommonSeeBean;
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


import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.bean.SinologyBean;

import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;

import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.story.bean.HearStoryBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

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


    @Headers("Cache-Control: public, max-age=28800")
    @GET("album_categories/1/albums{album_id}")
    Observable<BaseResponse<List<ErgeBean>>> getErgeData(@Path("album_id") String album_id);

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


    @GET("audio_categories/6/playlists?channel=new&offset=0&limit=20")
    Observable<BaseResponse<List<MusicBean>>> getMusicData();

    @GET("audio_categories/7/playlists?channel=new&offset=0&limit=20 http/1.1")
    Observable<BaseResponse<List<SinologyBean>>> getSinologyData();

    @GET("audio_categories/8/playlists?channel=new&offset=0&limit=20")
    Observable<BaseResponse<List<HearEnglishBean>>> getHearEnglishData();

    @GET("audio_categories/2/playlists?channel=new&offset=0&limit=20")
    Observable<BaseResponse<List<HearStoryBean>>> getHearStoryData();

    @GET("audio_categories/1/playlists?channel=new&offset=0&limit=20")
    Observable<BaseResponse<List<Listen_ErgeBean>>> getListen_ErgeBeanData();



    /**
     * http://api.t.ergedd.com/api/v1/albums/33/videos?channel=new&offset=0&limit=20&sensitive=8
     *
     * @param id
     * @return
     */
    @GET("albums/{id}/videos?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<CommonSeeBean>>> getDataCommon(@Path("id") int id);
}
