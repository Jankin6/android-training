package com.wangjj.android_training.mvp;

/**
 * Created by wangjj on 2016/6/24.
 */
public interface LoginPresenter {
    void validateCredentials(String username, String password);
    void destory();
}
