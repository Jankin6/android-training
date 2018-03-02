package com.wangjj.android_training;

import com.google.gson.JsonObject;
import com.wangjj.android_training.utils.AppUtil;
import com.wangjj.android_training.utils.Base64;


public class MyConfig {
    public boolean appNeedSignFirstly;
    public String appId;
    public String appBaseHost;
    public String appLegalAddress;
    public String wxAppId;
    public String wxApiUrlAccessToken;
    public String wxApiUrlUserInfo;


    public String getDeviceInfo() {
        JsonObject objectJson = new JsonObject();
        objectJson.addProperty("phone_model", "");
        objectJson.addProperty("release_channel", "official");
        objectJson.addProperty("app_version", AppUtil.appVersionName());
        objectJson.addProperty("os_version", AppUtil.androidVersion());
        objectJson.addProperty("device_token", "");
        objectJson.addProperty("platform", "Android");
        return Base64.encode(objectJson.toString().getBytes());
    }



}
