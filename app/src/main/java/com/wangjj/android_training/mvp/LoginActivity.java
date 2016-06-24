package com.wangjj.android_training.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wangjj.android_training.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangjj on 2016/6/24.
 */
public class LoginActivity extends AppCompatActivity implements LoginView{
    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        if(mProgress != null){
            mProgress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if(mProgress != null){
            mProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void setUserNameError() {
        if(mUsername != null){
            mUsername.setError("用户名错误");
        }
    }

    @Override
    public void setPasswordError() {
        if(mPassword != null){
            mPassword.setError("密码");
        }
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button)
    public void login(){
        if(mLoginPresenter != null){
            mLoginPresenter.validateCredentials(mUsername.getText().toString(), mPassword.getText().toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mLoginPresenter != null){
            mLoginPresenter.destory();
        }
    }
}
