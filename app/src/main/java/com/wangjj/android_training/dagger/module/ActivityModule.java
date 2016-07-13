package com.wangjj.android_training.dagger.module;

import android.app.Activity;

import com.wangjj.android_training.dagger.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangjj on 2016/7/5.
 */
@Module
public class ActivityModule {
    private final Activity mActivity;
    public ActivityModule(Activity activity){
        this.mActivity = activity;
    }

    @Provides @PerActivity
    Activity provideActivity(){
        return mActivity;
    }
}
