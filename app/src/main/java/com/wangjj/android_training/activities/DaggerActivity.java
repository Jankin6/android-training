package com.wangjj.android_training.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wangjj.android_training.model.UserDetailModel;
import com.wangjj.android_training.model.UserModel;
import com.wangjj.android_training.R;
import com.wangjj.android_training.dagger.component.DaggerUserComponent;
import com.wangjj.android_training.dagger.component.DaggerUserDetailComponent;
import com.wangjj.android_training.dagger.component.UserComponent;
import com.wangjj.android_training.dagger.component.UserDetailComponent;
import com.wangjj.android_training.dagger.module.UserDetailModule;
import com.wangjj.android_training.dagger.module.UserModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangjj on 2016/7/4.
 */
public class DaggerActivity extends AppCompatActivity {
    @BindView(R.id.username)
    TextView mUsername;
    @BindView(R.id.password)
    TextView mPassword;

    @Inject
    UserModel userModel;

    @Inject
    UserDetailModel userDetailModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ButterKnife.bind(this);
        UserComponent userComponent = DaggerUserComponent.builder().userModule(new UserModule()).build();
        UserDetailComponent userDetailComponent = DaggerUserDetailComponent.builder().userComponent(userComponent).userDetailModule(new UserDetailModule()).build();
        userDetailComponent.inject(this);
        mUsername.setText(userModel.username+", " + userDetailModel.nickname+", "+ userDetailModel.gender);
        mPassword.setText(userModel.password);
    }
}
