package com.Mar.beans;

public abstract interface Person {
    public static final int AGE = 0;
    public abstract void study();
    public abstract void eat();
    public abstract void play();
    default void add(){
        System.out.println("这是用default修饰的普通方法");
    }
}
