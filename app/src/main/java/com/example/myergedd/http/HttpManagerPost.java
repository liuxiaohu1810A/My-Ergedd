package com.example.myergedd.http;

import android.util.Log;

import com.example.myergedd.app.Globle;
import com.example.myergedd.app.MyApp;
import com.example.myergedd.utils.HttpUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManagerPost {
    private static volatile HttpManagerPost httpManagerPost;

    private HttpManagerPost() {
    }

    public static HttpManagerPost getInstance() {
        if (httpManagerPost == null) {
            synchronized (HttpManagerPost.class) {
                if (httpManagerPost == null) {
                    httpManagerPost = new HttpManagerPost();
                }
            }
        }
        return httpManagerPost;
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Globle.BASE_POST_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkhttpClient())
                .build();
    }


    private class MyverifyInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
//            request.newBuilder()
            Response response = chain.proceed(request);
//            request.newBuilder()
//                    .addHeader("Time-Stamp", time_stamp)
//                    .addHeader("Device-Key", device_key)
//                    .addHeader("Version", getVersion())
//                    .addHeader("Authorization", ChannelUtil.getAPIKEY() + ":" + "Android")
//                    .addHeader("channel", ChannelUtil.getChannel());

            return response;
        }
    }

    private class Myrewrite_cache_control_interceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!HttpUtils.isNetworkAvailable(MyApp.getInstance())) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response response = chain.proceed(request);
            if (HttpUtils.isNetworkAvailable(MyApp.getInstance())) {
                //有网络的时候读取接口上的headers里的配置，可以在这里统一配置
                String cache = request.cacheControl().toString();
                return response.newBuilder()
                        .header("Cache-Control", cache)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                        .removeHeader("Pragma")
                        .build();
            }
        }
    }

    //post 不可以做缓存
    private class MyCacheinterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上面的数据，要是没有网络的话我么就去缓存里面取数据
            if (!HttpUtils.isNetworkAvailable(MyApp.getInstance())) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }

            //利用拦截器发送出去
            Response originalResponse = chain.proceed(request);
            if (HttpUtils.isNetworkAvailable(MyApp.getInstance())) {
                int maxAge = 0;
                return originalResponse.newBuilder()
                        // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 15;
                return originalResponse.newBuilder()
                        // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Pragma")
                        //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    }

    public <T> T getServer(Class<T> tClass) {
        return getRetrofit().create(tClass);
    }

    private OkHttpClient getOkhttpClient() {
        //日志过滤器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                try {
                    String text = URLDecoder.decode(message, "utf-8");
                    Log.e("OKHttp-----", text);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    Log.e("OKHttp-----", message);
                }
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //设置缓存20M
        Cache cache = new Cache(new File(MyApp.getInstance().getCacheDir(), "Cache"), 20 * 1024 * 1024);
        MyCacheinterceptor myCacheinterceptor = new MyCacheinterceptor();
        MyverifyInterceptor verifyInterceptor = new MyverifyInterceptor();
        Myrewrite_cache_control_interceptor myrewrite_cache_control_interceptor = new Myrewrite_cache_control_interceptor();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(verifyInterceptor)
                .cache(cache)
                .addInterceptor(myrewrite_cache_control_interceptor)
                .addNetworkInterceptor(myrewrite_cache_control_interceptor)
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        return client;
    }
}
