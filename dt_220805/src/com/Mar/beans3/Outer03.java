package com.Mar.beans3;

public class Outer03 {
    private int id;

    public void out_method(){
        System.out.println("外部类方法");
        class Inner03{
            private int id;
            public void in_method(){
                System.out.println("内部类方法");
            }
        }
    }
}
