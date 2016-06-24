package com.wangjj.android_training.mvp;

/**
 * Created by wangjj on 2016/6/24.
 */
public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.OnLoginFinishedListener {
    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.mLoginView = loginView;
        this.mLoginInteractor = new LoginInteractorImpl();
    }
    @Override
    public void validateCredentials(String username, String password) {
        if(mLoginView != null) {
            mLoginView.showProgress();
        }
        if(mLoginInteractor != null){
            mLoginInteractor.login(username, password, this);
        }
    }

    @Override
    public void destory() {
        mLoginView = null;
        mLoginInteractor = null;
    }

    @Override
    public void onUserNameError() {
        if(mLoginView != null){
            mLoginView.setUserNameError();
            mLoginView.hideProgress();
        }

    }

    @Override
    public void onPasswordError() {
        if(mLoginView != null){
            mLoginView.setPasswordError();
            mLoginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(mLoginView != null){
            mLoginView.navigateToHome();
        }
    }
}
