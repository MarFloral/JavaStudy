package com.Mar.beans;

public class Person {
    private int id;
    private String name;
    private String phone;
    public int age = 22;
    public Person() {
        System.out.println("父类构造方法");
    }

    public Person(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void study(){
        System.out.println("父类学习");
    }
}
