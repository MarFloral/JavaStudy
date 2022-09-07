package com.Mar.beans;

public class Person {
    public int id;//编号
    public String name="张三";//姓名
    public char gender;//性别
    public double height;//身高
    public double weight;//体重
    public int chinese = 60;//语文
    public int math = 70;//数学

    public void userName(){
        System.out.println(name);
    }
    public int avg(){
        return (chinese+math)/2;
    }
}
