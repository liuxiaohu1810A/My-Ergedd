package com.example.myergedd.app;

import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.bean.StoryBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServier {
    String mUrl = "http://api.t.ergedd.com/api/v1/";
    @GET("album_categories")
    Observable<BaseResponse<List<CartoonBean>>> getCartoonData();

    @GET("album_categories/1/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<StoryBean>>> getStoryData();
}
