package com.wangjj.android_training.design_pattern.builder;

/**
 * Created by wangjianjun on 17/4/7.
 */

public class ConcreteBuilder extends Builder{
    @Override
    public void buildPartA() {
        mProduct.setPartA("ConcreteA");
    }

    @Override
    public void buildPartB() {
        mProduct.setPartB("ConcreteB");

    }

    @Override
    public void buildPartC() {
        mProduct.setPartC("ConcreteC");

    }
}
