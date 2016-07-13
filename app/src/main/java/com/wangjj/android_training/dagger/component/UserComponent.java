package com.wangjj.android_training.dagger.component;

import com.wangjj.android_training.model.UserModel;
import com.wangjj.android_training.dagger.module.UserModule;

import dagger.Component;

/**
 * Created by wangjj on 2016/7/3.
 */
@Component(modules = UserModule.class)
public interface UserComponent {
//    void inject(DaggerActivity daggerActivity);
    UserModel userModel();
}
