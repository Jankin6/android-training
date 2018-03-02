package com.wangjj.android_training.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

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

    // 取得版本号
    public static String appVersionName() {
        try {
            PackageInfo manager = MyApplication.getInstance().getPackageManager().getPackageInfo(
                    MyApplication.getInstance().getPackageName(), 0);
            return manager.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Unknown";
        }
    }

    public static String androidVersion() {
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        return "Android SDK: " + sdkVersion + " (" + release +")";
    }
}
