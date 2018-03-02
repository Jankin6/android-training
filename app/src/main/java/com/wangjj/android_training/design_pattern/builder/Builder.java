package com.wangjj.android_training.design_pattern.builder;

/**
 * Created by wangjianjun on 17/4/7.
 */

public abstract class Builder {
    Product mProduct = new Product();
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public Product getResult(){
        return mProduct;
    }
}
