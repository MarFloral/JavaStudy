package com.Mar.beans;

public class Student extends Person {
    private int age = 18;
    @Override//注解
    public void study() {
        System.out.println(super.getName() + "学习");
        super.study();
    }

    public Student() {
        System.out.println("子类构造方法" + this.age + super.age + age);
    }
}
