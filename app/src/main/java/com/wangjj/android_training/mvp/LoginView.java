package com.wangjj.android_training.mvp;

/**
 * Created by wangjj on 2016/6/24.
 */
public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigateToHome();

}
