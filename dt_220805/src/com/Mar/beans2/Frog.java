package com.Mar.beans2;

public class Frog extends Animal implements Swim {
    @Override
    public void eat() {
        System.out.println("青蛙吃小虫");
    }

    @Override
    public void swim() {
        System.out.println("青蛙会蛙泳");
    }
}
