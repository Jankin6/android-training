package com.wangjj.android_training.api.http.service;

import com.wangjj.android_training.entity.api.UploadImgEntity;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by wangjianjun on 17/4/18.
 */

public interface UploadService {

    @Multipart
    @POST("AppYuFaKu/uploadHeadImg")
    Observable<UploadImgEntity> uploadImage(@Part("uid") RequestBody uid, @Part("auth_key") RequestBody  auth_key, @Part MultipartBody.Part file);

    @POST("AppYuFaKu/uploadHeadImg")
    Observable<UploadImgEntity> uploadImage(@Body MultipartBody multipartBody);

    @Multipart
    @POST("AppYuFaKu/uploadHeadImg")
    Observable<UploadImgEntity> uploadImage(@Part() List<MultipartBody.Part> parts);


    // 带参数 上传
    // Call<String> uploadOne(@Part("sign") String sign,@Part("appKey") String appKey,@Part("osName") String osName,@Part("memberNo") String memberNo, @Part  MultipartBody.Part file);
    // Call<String> uploadOne(@PartMap Map<String,String> params, @Part  MultipartBody.Part file);
    // Call<String> uploadOne(@Query("sign") String sign, @Query("appKey") String appKey, @Query("osName") String osName, @Query("memberNo") String memberNo, @Part  MultipartBody.Part file);
    @Multipart
    @POST("AppYuFaKu/uploadHeadImg")
    Observable<UploadImgEntity> uploadImage(@QueryMap Map<String, String> params , @Part MultipartBody.Part file);

}
