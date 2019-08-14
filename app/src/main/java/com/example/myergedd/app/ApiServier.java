package com.example.myergedd.app;

import android.media.AudioRecord;

import com.example.myergedd.activity.commonsee.CommonSeeBean;
import com.example.myergedd.base.BaseRecordResponse;
import com.example.myergedd.base.BaseResponse;

import com.example.myergedd.bean.ChosenThree;
import com.example.myergedd.bean.ChosenTwoBean;

import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.bean.EarlyBean;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.ErgeBean;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.bean.SearchSeeAlbumsBean;
import com.example.myergedd.bean.SearchSeeHotBean;
import com.example.myergedd.bean.SearchSeeVideosBean;
import com.example.myergedd.bean.SinologyBean;
import com.example.myergedd.bean.StoryBean;
import com.example.myergedd.bean.SynthesizeBean;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;

import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.story.bean.HearStoryBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServier {
    /**
     * http://api.ergedd.com/api/v1/albums/home_recommended
     * 精选布局二
     *
     * @return
     */
    @Headers("Cache-Control: public, max-age=28800")
    @GET("albums/home_recommended")
    Observable<BaseResponse<List<ChosenTwoBean>>> getDataChosenTwo();

    /**
     * http://api.ergedd.com/api/v1/home_items
     * 精选链表数据
     *
     * @return
     */
    @Headers("Cache-Control: public, max-age=28800")
    @GET("home_items")
    Observable<BaseResponse<List<ChosenThree>>> getDataChosenThree();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("album_categories/4/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<CartoonBean>>> getCartoonData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("album_categories/1/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<ErgeBean>>> getErgeData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("album_categories/3/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<StoryBean>>> getStoryData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("album_categories/6/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<EarlyBean>>> getEarlyData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("album_categories/5/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<SynthesizeBean>>> getSynthesizeData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("album_categories/2/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<EnglishBean>>> getEnglishData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("audio_categories/6/playlists?channel=new&offset=0&limit=20")
    Observable<BaseResponse<List<MusicBean>>> getMusicData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("audio_categories/7/playlists?channel=new&offset=0&limit=20 http/1.1")
    Observable<BaseResponse<List<SinologyBean>>> getSinologyData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("audio_categories/8/playlists?channel=new&offset=0&limit=20")
    Observable<BaseResponse<List<HearEnglishBean>>> getHearEnglishData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("audio_categories/2/playlists?channel=new&offset=0&limit=20")
    Observable<BaseResponse<List<HearStoryBean>>> getHearStoryData();

    @Headers("Cache-Control: public, max-age=28800")
    @GET("audio_categories/1/playlists?channel=new&offset=0&limit=20")
    Observable<BaseResponse<List<Listen_ErgeBean>>> getListen_ErgeBeanData();

    /**
     * http://api.t.ergedd.com/api/v1/albums/33/videos?channel=new&offset=0&limit=20&sensitive=8
     *
     * @param id
     * @return
     */
    @Headers("Cache-Control: public, max-age=28800")
    @GET("albums/{id}/videos?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<CommonSeeBean>>> getDataCommon(@Path("id") int id);

    @Headers("Cache-Control: public, max-age=28800")
    @GET("albums/search?&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<SearchSeeAlbumsBean>>> getDataAlbumsSearch(@Query("keyword") String keyword);

    @Headers("Cache-Control: public, max-age=28800")
    @GET("videos/search?&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<SearchSeeVideosBean>>> getDataVideoSearch(@Query("keyword") String keyword);

    @Headers("Cache-Control: public, max-age=28800")
    @POST("getVideoSearchKeyword")
    Observable<BaseRecordResponse<SearchSeeHotBean>> getDataHotSearch();

    @Headers("Cache-Control: public, max-age=28800")
    @FormUrlEncoded
    @POST("getAudioByPlaylistId")
    Observable<BaseRecordResponse<AudioRecord>> requestAllAudioByPlayListId(@Field("apid") int audioPlayListId, @Field("offset") int offset, @Field("limit") int limit);
}
