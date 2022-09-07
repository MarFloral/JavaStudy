package com.Mar.test;

public class Test {
    public static void main(String[] args) {
        String name1 = "admin";
        String name2 = "admin";

        String name3 = new String("admin");
        String name4 = new String("admin");

        System.out.println(name1 == name2);
        System.out.println(name3 == name4);
        System.out.println(name1 == name3);
    }
}
