package com.Mar.beans3;

public class Outer02 {
    private int id;
    public void out_method(){
        System.out.println("外部类方法");
    }
    public static class Inner02{
        public void in_method(){
            System.out.println("内部类方法");
        }
    }
}
