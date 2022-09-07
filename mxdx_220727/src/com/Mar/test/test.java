package com.Mar.test;

import com.Mar.beans.Person;

public class test {

    public static void main(String[] args) {
        //创建对象
        Person p = new Person();
        p.weight = 123;
        System.out.println(p.gender);
        System.out.println(p.avg());
        p.userName();
    }
}
