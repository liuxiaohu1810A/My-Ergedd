package com.example.myergedd.app;

import com.example.myergedd.activity.commonsee.CommonSeeBean;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.ChosenThree;
import com.example.myergedd.bean.ChosenTwoBean;
import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.bean.EarlyBean;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.StoryBean;
import com.example.myergedd.bean.SynthesizeBean;
import com.example.myergedd.fragment.english.contract.English;

import java.util.List;
import java.util.function.DoubleUnaryOperator;

import io.reactivex.Observable;
import retrofit2.http.GET;
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

    @GET("album_categories/1/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<StoryBean>>> getStoryData();

    @GET("album_categories/6/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<EarlyBean>>> getEarlyData();

    @GET("album_categories/5/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<SynthesizeBean>>> getSynthesizeData();

    @GET("album_categories/2/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<EnglishBean>>> getEnglishData();

    /**
     * http://api.t.ergedd.com/api/v1/albums/33/videos?channel=new&offset=0&limit=20&sensitive=8
     *
     * @param id
     * @return
     */
    @GET("albums/{id}/videos?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<CommonSeeBean>>> getDataCommon(@Path("id") int id);
}
