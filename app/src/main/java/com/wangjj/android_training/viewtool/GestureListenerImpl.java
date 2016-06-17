package com.wangjj.android_training.viewtool;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by WangJJ on 16/6/17.
 */
public class GestureListenerImpl implements GestureDetector.OnGestureListener{
    private final String TAG = "GestureListenerImpl";

    //触摸屏幕时会调用该方法
    @Override
    public boolean onDown(MotionEvent e) {
        Log.i(TAG,"ondown");
        return false;
    }

    //手指在屏幕上按下,且未移动和松开时回调该方法
    @Override
    public void onShowPress(MotionEvent e) {

    }

    //手指轻击屏幕时会回调该方法
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    //手指在屏幕上滚动时会回调该方法
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    //手指长按屏幕时会调用该方法
    @Override
    public void onLongPress(MotionEvent e) {

    }

    //手指在屏幕上拖动时会调用该方法
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
