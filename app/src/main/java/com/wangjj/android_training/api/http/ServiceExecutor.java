package com.wangjj.android_training.api.http;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class ServiceExecutor {

    private ServiceExecutor() {
    }

    private static ServiceExecutor instance;

    public static ServiceExecutor getInstance() {
        if (instance == null) {
            instance = new ServiceExecutor();
        }
        return instance;
    }

    public <T> void execute(Observable<T> observable, final ProgressSubscriber<T> progressSubscriber) {
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        progressSubscriber.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(progressSubscriber);
    }

}
