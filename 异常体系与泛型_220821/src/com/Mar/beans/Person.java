package com.Mar.beans;

public class Person {
    public void add(Demo<? extends Person> o){//限制类型必须时Person的子类
        System.out.println(125);
    }
}
