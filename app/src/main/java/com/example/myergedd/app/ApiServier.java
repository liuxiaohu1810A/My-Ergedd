package com.example.myergedd.app;

import com.example.myergedd.base.BaseResponse;



import com.example.myergedd.bean.ChosenThree;
import com.example.myergedd.bean.ChosenTwoBean;

import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.bean.EarlyBean;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.ErgeBean;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.bean.SinologyBean;
import com.example.myergedd.bean.StoryBean;
import com.example.myergedd.bean.SynthesizeBean;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;

import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.story.bean.HearStoryBean;

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



}
