package com.property.glory.propertyservice.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午2:57
 */

public class RetrofitClient
{
    private static Retrofit retrofit;

    /**
     * 获取retrofit实例
     * @return
     */
    public static Retrofit getRetrofit()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(HttpApi.BaseUrl)// 设置 网络请求 Url
                    .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//支持RxJava
                    .build();
        }
        return retrofit;
    }
}
