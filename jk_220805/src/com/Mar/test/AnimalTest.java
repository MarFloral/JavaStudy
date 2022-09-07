package com.Mar.test;

import com.Mar.beans1.Animal;
import com.Mar.beans1.Cat;
import com.Mar.beans1.Dog;

public class AnimalTest {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        boolean a2 = cat instanceof Animal;
        System.out.println(a2);
        //编译看左，执行看右
        Animal animal = new Cat();
        animal.eat();
        boolean a1 = animal instanceof Cat;
        System.out.println(a1);
        Animal animal1 = new Dog();
        animal1.eat();

        Animal animal2 = new Cat();
        Cat cat1 = (Cat) animal2;

        Cat cat2 = (Cat) animal;
        cat2.eat();
        cat2.a();
    }
}
