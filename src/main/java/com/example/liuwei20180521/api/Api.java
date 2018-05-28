package com.example.liuwei20180521.api;

import android.provider.MediaStore;

import com.example.liuwei20180521.bean.VideoBean;
import com.example.liuwei20180521.bean.WenBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/5/21.
 */

public interface Api {
    @GET("satinApi")
    Observable<WenBean>doGet(@Query("type")int type,@Query("page")int page);

    @GET("satinApi")
    Observable<VideoBean>doPost(@Query("type")int type, @Query("page")int page);
}
