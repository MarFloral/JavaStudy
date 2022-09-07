package com.Mar.beans;

public class Teacher {
    public String name = "阿斯顿";//姓名
    public int age = 22;//年龄
    public int gz = 2000;//工资
    public void Teach(){
        System.out.println(name);
    }
    public void Show(){
        System.out.println(name+","+age+","+gz);
    }
}
