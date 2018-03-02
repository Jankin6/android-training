package com.wangjj.android_training.api.http.service;

import com.wangjj.android_training.entity.api.VideoListEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by wangjianjun on 17/4/14.
 */

public interface TestService {
    @POST("AppFiftyToneGraph/videoLink")
    Observable<VideoListEntity> getAllVedioBy(@Body boolean once_no);
}
