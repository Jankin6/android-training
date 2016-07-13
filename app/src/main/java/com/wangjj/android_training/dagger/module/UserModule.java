package com.wangjj.android_training.dagger.module;

import com.wangjj.android_training.model.UserModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangjj on 2016/7/3.
 */
@Module
public class UserModule {
    @Provides
    UserModel provideUserModel(){
        return new UserModel("wangjj", "123456");
    }
}
