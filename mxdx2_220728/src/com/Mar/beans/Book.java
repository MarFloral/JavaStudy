package com.Mar.beans;

public class Book {
    private int id;//编号
    private String name;//书名
    private String author;//作者
    private double price;//价格

    public Book(){//空参构造方法

    }
    public Book(int id,String name,String author,double price){//带所有属性的构造方法

    }
    public Book(String name,String author,double price){//除id外的构造方法

    }
    public void setPrice(double pri) {
        price = pri;
    }
    public double getPrice() {
        return price;
    }

    public void setId(int id1){
        id = id1;
    }
    public int getId() {
        return id;
    }

    public void setName(String name1){
        name = name1;
    }
    public String getName(){
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
}
