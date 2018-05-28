package com.example.liuwei20180521.utils;

import com.example.liuwei20180521.api.Api;
import com.example.liuwei20180521.app.App;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/21.
 */

public class OkHttpUtils {


    private static OkHttpUtils instance;
    private final Retrofit retrofit;

    //单利
    private OkHttpUtils (String uri){

        //ok
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(3000, TimeUnit.SECONDS);
        okHttpClient.readTimeout(3000,TimeUnit.SECONDS);

        //re
        retrofit = new Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static OkHttpUtils getInstance(String uri){
        if(instance==null){
            synchronized (OkHttpUtils.class){
                if(null==instance){
                    instance = new OkHttpUtils(uri);
                }
            }
        }
        return instance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }

}
