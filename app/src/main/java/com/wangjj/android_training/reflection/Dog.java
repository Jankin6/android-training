package com.wangjj.android_training.reflection;

/**
 * Created by wangjianjun on 17/4/1.
 */

public class Dog extends Animal {
    private int loyalty;
    private int weight;



    private Dog(int loyalty){
        this.loyalty = loyalty;

    }

    public Dog(){

    }

    public Dog(String name){
       this.name = name;
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

}
