package com.wangjj.android_training.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wangjj.android_training.MyApplication;
import com.wangjj.android_training.dagger.component.ApplicationComponent;
import com.wangjj.android_training.dagger.module.ActivityModule;

/**
 * Created by wangjj on 2016/7/13.
 */
public abstract class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
        initVariables(savedInstanceState);
        initViews();
        loadData();
    }
    //初始化变量，包括Intent带的数据和程序内的变量
    protected abstract void initVariables(Bundle savedInstanceState);
    //加载布局文件，初始化控件，为控件挂上事件方法
    protected abstract void initViews();
    //加载数据，本地数据或协议的数据
    protected abstract void loadData();

    /**
     * Get the Main Application component for dependency injection.
     * @return
     */
    protected ApplicationComponent getApplicationComponent(){
        return MyApplication.getInstance().getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     * @return
     */
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, int resTitle) {
        initToolBar(toolbar, homeAsUpEnabled, getString(resTitle));
    }
}
