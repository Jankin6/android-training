package com.wangjj.android_training.mvp;

/**
 * Created by wangjj on 2016/6/24.
 */
public interface LoginInteractor {
    interface OnLoginFinishedListener{
        void onUserNameError();
        void onPasswordError();
        void onSuccess();
    }
    void login(String userName, String password, OnLoginFinishedListener onLoginFinishedListener);
}
