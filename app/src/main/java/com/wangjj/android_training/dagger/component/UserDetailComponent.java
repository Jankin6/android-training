package com.wangjj.android_training.dagger.component;

import com.wangjj.android_training.activities.DaggerActivity;
import com.wangjj.android_training.dagger.module.UserDetailModule;

import dagger.Component;

/**
 * Created by wangjj on 2016/7/4.
 */
@Component(modules = UserDetailModule.class, dependencies = UserComponent.class)
public interface UserDetailComponent {
    void inject(DaggerActivity daggerActivity);
}
