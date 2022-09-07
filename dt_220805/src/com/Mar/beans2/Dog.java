package com.Mar.beans2;

public class Dog extends Animal implements Swim {
    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗会狗刨游泳");
    }
}
