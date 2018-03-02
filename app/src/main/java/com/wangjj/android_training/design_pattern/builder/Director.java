package com.wangjj.android_training.design_pattern.builder;

/**
 * Created by wangjianjun on 17/4/7.
 */

public class Director {
    private Builder mBuilder;

    public Product construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
