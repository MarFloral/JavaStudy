package com.Mar.test;

import com.Mar.beans3.Outer01;

public class OuterTest {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        //outer01.out_method();

        //直接找内部类
        Outer01.Inner outerIn01 = new Outer01().new Inner();
        outerIn01.in_method();
        Outer01.Inner outerIn02 = outer01.new Inner();
        outerIn02.in_method();
    }
}
