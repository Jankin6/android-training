package com.wangjj.android_training;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.wangjj.android_training.entity.User;

/**
 * Created by wangjianjun on 16/8/10.
 */
public class MyUserDefaultCache {
    private static User mUserCache;

    public static User getUserInfo() {
        if(mUserCache == null){
            String str = MySharedPreferences.getDefault(MySharedPreferences.KEY_APP_DEFAULT_USER,"");
            if(!TextUtils.isEmpty(str)){
                try{
                    mUserCache = new Gson().fromJson(str, User.class);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                mUserCache = new User();
            }
        }
        return mUserCache;
    }

    public static String getToken(){
        if(getUserInfo() == null || TextUtils.isEmpty(getUserInfo().token)){
            return "";
        }
        return getUserInfo().token;
    }

    public static void cacheUser(User userCacheInfo){
        mUserCache = userCacheInfo;
        MySharedPreferences.setDefault(MySharedPreferences.KEY_APP_DEFAULT_USER, new Gson().toJson(userCacheInfo));
    }

    public static void logout(){
        mUserCache = null;
        MySharedPreferences.setDefault(MySharedPreferences.KEY_APP_DEFAULT_USER, "");

    }
}
