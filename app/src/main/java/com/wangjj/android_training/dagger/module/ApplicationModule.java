package com.wangjj.android_training.dagger.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangjj on 2016/7/5.
 */
@Module
public class ApplicationModule {
    private Application application;
    public ApplicationModule(Application application){
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext(){
        return application;
    }
}
