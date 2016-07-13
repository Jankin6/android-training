package com.wangjj.android_training.dagger.component;

import android.content.Context;

import com.wangjj.android_training.dagger.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wangjj on 2016/7/5.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();
}
