package com.wangjj.android_training.mvp;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/**
 * Created by wangjj on 2016/6/24.
 */
public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String userName, final String password, final OnLoginFinishedListener onLoginFinishedListener) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(userName)){
                    onLoginFinishedListener.onUserNameError();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    onLoginFinishedListener.onPasswordError();
                    return;
                }
                onLoginFinishedListener.onSuccess();
            }
        }, 2000);
    }
}
