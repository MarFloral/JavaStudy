package com.Mar.beans3;

public class Outer01 {
    private int age = 18;
    public void out_method(){
        System.out.println("外部类方法");
        Inner inner = new Inner();  //创建内部类对象
        inner.in_method();
    }
    public class Inner{//内部类
        private int id;
        private int age = 20;
        public void in_method(){
            System.out.println("内部类方法" + this.age + " " + Outer01.this.age);
        }
    }

    public class Inner2{

    }
}
