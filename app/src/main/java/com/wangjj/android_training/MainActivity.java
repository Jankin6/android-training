package com.wangjj.android_training;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.wangjj.android_training.activities.ActivityPullToRefresh;
import com.wangjj.android_training.activities.BaseActivity;
import com.wangjj.android_training.activities.DaggerActivity;
import com.wangjj.android_training.activities.RetrofitActivity;
import com.wangjj.android_training.activities.annotation.TestAnnotationActivity;
import com.wangjj.android_training.adapter.MainListAdapter;
import com.wangjj.android_training.utils.AppUtil;
import com.wangjj.android_training.utils.recyclerview.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.main_drawer_layout)
    DrawerLayout mMainDrawerLayout;

    private MainListAdapter mMainListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initToolBar(mToolbar, true, R.string.app_name);
        mToolbar.setNavigationIcon(R.mipmap.ic_drawer_home);


        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        List<String> dataList = new ArrayList<>();
        dataList.add("渠道" + AppUtil.getApplicationMetaValue("UMENG_CHANNEL"));
        dataList.add("dagger");
        dataList.add("pulltorefresh");
        dataList.add("thread");
        dataList.add("注解");
        dataList.add("retrofit");
        mMainListAdapter = new MainListAdapter(dataList);
        mRecyclerview.setAdapter(mMainListAdapter);
        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                if (i == 1) {
                    startActivity(new Intent(MainActivity.this, DaggerActivity.class));
                } else if (i == 2) {
                    startActivity(new Intent(MainActivity.this, ActivityPullToRefresh.class));
                } else if (i == 4) {
                    startActivity(new Intent(MainActivity.this, TestAnnotationActivity.class));
                } else if (i == 5) {
                    startActivity(new Intent(MainActivity.this, RetrofitActivity.class));

                }
            }
        });


    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //主界面左上角的icon点击反应
                mMainDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
