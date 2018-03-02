package com.wangjj.android_training.entity;

import java.io.Serializable;

/**
 * Created by wangjianjun on 17/4/13.
 */

public class BaseEntity implements Serializable{
    public int code;
    public String message;
    public int needLogin;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(int needLogin) {
        this.needLogin = needLogin;
    }
}
