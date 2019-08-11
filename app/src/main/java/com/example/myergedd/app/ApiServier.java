package com.example.myergedd.app;

import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.DongHua;
import com.example.myergedd.bean.SongBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServier {
    String mUrl = "http://api.ergedd.com/api/v1/";
   /* 小猪佩奇:
    Get提交
    http://api.ergedd.com/api/v1/albums/532/videos?channel=new&offset=0&limit=20&sensitive=8
    萌鸡小队:
    Get提交
    http://api.ergedd.com/api/v1/albums/532/videos?channel=new&offset=0&limit=20&sensitive=8
    旺旺立大功:
    Get提交
    http://api.ergedd.com/api/v1/albums/175/videos?channel=new&offset=0&limit=20&sensitive=8*/
    @GET("album_categories")
    Observable<BaseResponse<List<DongHua>>> get();

    @GET("album_categories/1/albums?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BaseResponse<List<SongBean>>> getEg();
   /* @GET("album_categories")
    Observable<BaseResponse<List<DongHua>>> get();

    @GET("album_categories")
    Observable<BaseResponse<List<DongHua>>> get();*/





}
