package com.Mar.test;

import com.Mar.beans.*;

public class Engineer {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        teacher.Teach();
        teacher.Show();

        Box box = new Box();
        System.out.println(box.TiJi());

        Dog dog = new Dog();
        dog.eat();

        Cat cat = new Cat();
        cat.eat();

        Triange triange = new Triange();
        System.out.println(triange.area());

        Reatangle reatangle = new Reatangle();
        System.out.println(reatangle.area());

        Circle circle = new Circle();
        System.out.println(circle.area());
    }
}
