package com.wangjj.android_training.dagger.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wangjj on 2016/6/30.
 */
@Scope
@Retention(RUNTIME)
public @interface PerFragment {
}
