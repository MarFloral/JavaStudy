package com.Mar.test;

import com.Mar.beans.Color01;

public class Test {
    public static void main(String[] args) {
        Color01.BLUE.run();
        System.out.println(Color01.BLUE);
        System.out.println(Color01.GREEN.getDeclaringClass());
    }
}
