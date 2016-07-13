package com.wangjj.android_training;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by wangjj on 2016/7/5.
 */
public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
