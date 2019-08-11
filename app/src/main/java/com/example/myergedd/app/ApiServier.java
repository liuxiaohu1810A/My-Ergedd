package com.example.myergedd.app;

import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.DongHua;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServier {
    String mUrl = "http://api.t.ergedd.com/api/v1/";
    @GET("album_categories")
    Observable<BaseResponse<List<DongHua>>> get();
}
