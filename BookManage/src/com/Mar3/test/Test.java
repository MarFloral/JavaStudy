package com.Mar3.test;

public class Test {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(getType(a));
    }
    private static Class getType(Object a) {
        return a.getClass();
    }
}
