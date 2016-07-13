package com.wangjj.android_training.dagger.component;

import android.app.Activity;

import com.wangjj.android_training.dagger.module.ActivityModule;
import com.wangjj.android_training.dagger.scope.PerActivity;

import dagger.Component;

/**
 * Created by wangjj on 2016/7/5.
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    Activity activity();
}
