package com.wangjj.android_training.dagger.module;

import com.wangjj.android_training.model.UserDetailModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangjj on 2016/7/4.
 */
@Module
public class UserDetailModule {
    @Provides
    UserDetailModel provideUserDetailModel(){
        return new UserDetailModel("男", "jj");
    }
}
