package com.Mar.test;

import com.Mar.beans.User;

public class UserTest {
    public static void main(String[] a) throws ClassNotFoundException {
        //正常创建 自己的引用 = 自己的实例
        User user = new User();

        //多态创建 父类的引用 = 自己的实例
//        Animal animal = new Cat();

        //反射创建：
        //对象.getClass();
        Class c1 = user.getClass();

        //类名.class;
        Class c2 = User.class;

        //Class.forName("com.Mar.beans.User")（地址全称）
        Class c3 = Class.forName("com.Mar.beans.User");//需要抛出异常
        System.out.println(c1);//class com.Mar.beans.User
        System.out.println(c2);//class com.Mar.beans.User
        System.out.println(c3);//class com.Mar.beans.User
    }
}
