package com.wangjj.android_training.api.http;

import android.app.Activity;
import android.content.Context;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.wangjj.android_training.MyLog;
import com.wangjj.android_training.utils.ToastUtil;
import com.wangjj.android_training.widget.MyProgressDialog;

import org.json.JSONException;

import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;
import rx.Subscriber;

/**
 * Created by wangjianjun on 17/4/14.
 */

public abstract class ProgressSubscriber<T> extends Subscriber<T> implements MyProgressDialog.OnCancelListener{
    private MyProgressDialog mProgressDialog;
    private boolean cancelable = true;
    private boolean isShow = true;
    private SoftReference<Activity> mActivitySoftReference;
    public ProgressSubscriber(Activity activity) {
        this(activity, true, true);
    }

    public ProgressSubscriber(Activity activity, boolean isShow, boolean cancelable){
        mActivitySoftReference = new SoftReference(activity);
        Context context = mActivitySoftReference.get();
        this.isShow = isShow;
        this.cancelable = cancelable;
        mProgressDialog = new MyProgressDialog(context);
        mProgressDialog.setCancelable(cancelable);
        if(cancelable){
            mProgressDialog.setOnCancelListener(this);
        }
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        if(mProgressDialog != null) mProgressDialog.setCancelable(cancelable);
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    /**
     * 显示加载框
     */
    public void showProgressDialog() {
        if (!isShow) return;
        if (mProgressDialog != null){
            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        }

    }


    /**
     * 隐藏
     *
     */
    public void dismissProgressDialog() {
        if (!isShow) return;
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        e.printStackTrace();
        MyLog.API.e(e.getMessage());
        if (e instanceof HttpException) {
            ToastUtil.showToastMessage("网络连接异常,请检查网络设置");
        }else if (e instanceof ConnectException || e instanceof SocketTimeoutException) {
            ToastUtil.showToastMessage("服务器连接异常,请稍后再试");
        } else if (e instanceof JsonParseException || e instanceof JsonIOException || e instanceof JSONException) {
            ToastUtil.showToastMessage("数据解析异常");
        } else {
            ToastUtil.showToastMessage("未知错误,请稍后再试");
        }
        _onError(e);
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onCancel() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    public abstract void _onNext(T t);
    public abstract void _onError(Throwable e);
}
