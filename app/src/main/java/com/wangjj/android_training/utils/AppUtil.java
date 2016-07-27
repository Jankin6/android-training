package com.wangjj.android_training.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.wangjj.android_training.MyApplication;

/**
 * Created by wangjj on 2016/7/25.
 */
public class AppUtil {
    public static String getApplicationMetaValue(String name){
        String value = "";
        try {
            ApplicationInfo applicationInfo = MyApplication.getInstance().getPackageManager()
                    .getApplicationInfo(MyApplication.getInstance().getPackageName(), PackageManager.GET_META_DATA);
            value = applicationInfo.metaData.getString(name);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}
