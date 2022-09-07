package com.Mar.test;

import com.Mar.beans3.Outer04;

public class Outer04Test {
    public static void main(String[] args) {
        new Outer04().out_method();
        //新建类继承Outer04，内部可以重写方法
        new Outer04(){
            @Override
            public void out_method() {
                System.out.println("HelloWorld");
            }
        }.out_method();
        Outer04 outer04 = new Outer04(){
            @Override
            public void out_method() {
                System.out.println("HE");
            }
        };
        outer04.out_method();
    }
}
