package com.wangjj.android_training.dagger.module;

import android.content.Context;

import com.wangjj.android_training.MyApplication;
import com.wangjj.android_training.model.UserCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangjj on 2016/7/5.
 */
@Module
public class ApplicationModule {
    private MyApplication application;
    public ApplicationModule(MyApplication application){
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext(){
        return application;
    }

    @Provides @Singleton
    UserCache provideUserCache(UserCache userCache){
        return userCache;
    }
}
