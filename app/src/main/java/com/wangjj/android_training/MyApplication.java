package com.wangjj.android_training;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.wangjj.android_training.dagger.component.ApplicationComponent;
import com.wangjj.android_training.dagger.component.DaggerApplicationComponent;
import com.wangjj.android_training.dagger.module.ApplicationModule;

/**
 * Created by wangjj on 2016/7/5.
 */
public class MyApplication extends Application {
    private static MyApplication sMyApplication;
    private ApplicationComponent mApplicationComponent;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApplication = this;
        initInjector();
    }

    public static MyApplication getInstance(){
        return sMyApplication;
    }

    private void initInjector(){
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }
}
