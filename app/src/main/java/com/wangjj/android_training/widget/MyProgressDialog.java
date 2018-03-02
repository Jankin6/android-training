package com.wangjj.android_training.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by wangjianjun on 17/4/14.
 */

public class MyProgressDialog {
    private Context mContext;
    private ProgressDialog pd;
    private boolean cancelable = true;
    private OnCancelListener mOnCancelListener;

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        if(pd != null){
            pd.setCancelable(cancelable);
        }
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        mOnCancelListener = onCancelListener;
    }

    public MyProgressDialog(Context context){
        mContext = context;
        pd = new ProgressDialog(mContext);
        pd.setMessage("正在请求中...");
        pd.setCancelable(cancelable);
        pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if(mOnCancelListener != null){
                    mOnCancelListener.onCancel();
                }
            }
        });
    }



    public void show(){
        if(pd != null){
            pd.show();
        }

    }

    public boolean isShowing(){
        if(pd != null){
            return pd.isShowing();
        }
        return false;

    }

    public void dismiss(){
        if(pd != null){
            pd.dismiss();
        }
    }

    public interface OnCancelListener{
        public void onCancel();

    }

}
