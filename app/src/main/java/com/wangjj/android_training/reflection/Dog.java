package com.wangjj.android_training.reflection;

import android.view.View;

/**
 * Created by wangjianjun on 17/4/1.
 */

public class Dog extends Animal implements View.OnClickListener{
    public int loyalty;
    private int weight;

    public Dog(String name){
       super.name = name;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void onClick(View v) {

    }
}
