package com.wangjj.android_training.annotation;

import android.app.Activity;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangjianjun on 17/3/31.
 */

public class ViewInjectUtil {

    public static final String KEY_METHOD_CONTENT = "setContentView";
    public static final String KEY_METHOD_FIND_VIEW_BY_ID = "findViewById";

    public static void inject(Activity activity){
        injectContentView(activity);
        injectBindViews(activity);

    }


    public static void injectContentView(Activity activity){
        Class<?> clazz = activity.getClass();
        if(clazz.isAnnotationPresent(ContentView.class)){
            ContentView contentView = clazz.getAnnotation(ContentView.class);
            if(contentView != null){
                int viewId = contentView.value();
                try {
                    Method method = clazz.getMethod(KEY_METHOD_CONTENT, int.class);
                    method.setAccessible(true);
                    method.invoke(activity, viewId);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void injectBindViews(Activity activity){
        Class<?> clazz = activity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if(field.isAnnotationPresent(BindView.class)){
                BindView bindView = field.getAnnotation(BindView.class);
                if(bindView != null){
                    int viewId = bindView.value();

                    try {
                        Method method = clazz.getMethod(KEY_METHOD_FIND_VIEW_BY_ID, int.class);
                        method.setAccessible(true);
                        Object view = method.invoke(activity, viewId);
                        if(view != null){
                            field.setAccessible(true);
                            field.set(activity, view);
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
}
