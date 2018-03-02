package com.wangjj.android_training;

public enum MyLog {

    WANGJJ("wangjianjun", true),
    API("api", true);

    private String logTag;
    private boolean isEnable;

    MyLog(String tag, boolean enable) {
        this.logTag = tag;
        this.isEnable = enable;
    }

    private final static String TAG = "training";

    /**
     * Don't use this when obfuscating class names!
     */

    public void v(String message) {

        if (!isEnable) return;

        if (message == null) return;

        android.util.Log.v(logTag == null ? TAG : logTag, message);
    }

    public void d(String message) {

        if (!isEnable) return;

        if (message == null) return;

        android.util.Log.d(logTag == null ? TAG : logTag, message);
    }

    public void i(String message) {

        if (!isEnable) return;

        if (message == null) return;
        android.util.Log.i(logTag == null ? TAG : logTag, message);
    }

    public void e(String message) {

        if (!isEnable) return;

        if (message == null) return;
        android.util.Log.e(logTag == null ? TAG : logTag, message);
    }

}
