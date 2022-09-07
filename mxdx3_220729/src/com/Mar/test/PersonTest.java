package com.Mar.test;

import com.Mar.beans.Person;

import java.util.Arrays;

public class PersonTest {
    public static void main(String[] args) {
        //Person person = new Person();
        Person person = Person.getPerson();
        Person person1 = Person.getPerson();
        System.out.println(person1);
        System.out.println(person);

        System.out.println(person == person1);
        int b = person1.setId(3);
        int a = person.setId(5);

        System.out.println(a);
        System.out.println(b);
    }
}
