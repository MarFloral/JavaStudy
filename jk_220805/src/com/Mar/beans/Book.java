package com.Mar.beans;

public class Book {
    private int id;//书编号
    private String name;//书名
    private String author;//作者
    private double price;//价格
    private String press;//出版社

    public Book() {
    }

    public Book(int id, String name, String author, double price, String press) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
    }

    public Book(String name, String author, double price, String press) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                '}';
    }
}
