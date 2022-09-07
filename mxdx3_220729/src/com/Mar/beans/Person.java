package com.Mar.beans;

public class Person {
    private int id;
    private String userName;
    private String passWord;
    private int age;
    public static Person person = new Person();

    private Person() {
    }

    public static Person getPerson() {
        return person;
    }

    public Person(int id, String userName, String passWord, int age) {
        this (userName,passWord,age);
//        this.id = id;
//        this.userName = userName;
//        this.passWord = passWord;
        this.age = age;
    }

    public Person(String userName, String passWord, int age) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
    }

    public int setId(int id) {
        return this.id = id;
    }
    public void setUserName(int id) {
        int a = setId(id);
        System.out.println(a);
    }
}
