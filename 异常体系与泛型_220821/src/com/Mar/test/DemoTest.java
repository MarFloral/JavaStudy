package com.Mar.test;

import com.Mar.beans.Demo;
import com.Mar.beans.Person;
import com.Mar.beans.User;

public class DemoTest {
    public static void main(String[] args) {
        //任意
        Demo demo = new Demo();
        demo.aTest(123);
        //单一
        Demo<String> demo1 = new Demo<>();
        demo1.aTest("abc");
        //自定义类
        Demo<User> demo2 = new Demo<>();
        demo2.aTest(new User());

        //
        Person person = new Person();
        person.add(demo2);


    }
}
