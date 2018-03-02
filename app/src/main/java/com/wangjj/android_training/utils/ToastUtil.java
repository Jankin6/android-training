package com.wangjj.android_training.utils;

import android.widget.Toast;

import com.wangjj.android_training.MyApplication;

public class ToastUtil {


	public static void showToastMessage(String message){
		Toast.makeText(MyApplication.getInstance(), message, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * @Description: 显示Toast消息
	 * @param strId
	 */
	public static void showToastMessage(int strId){
		Toast.makeText(MyApplication.getInstance(), MyApplication.getInstance().getString(strId), Toast.LENGTH_SHORT).show();
	}
	

}
