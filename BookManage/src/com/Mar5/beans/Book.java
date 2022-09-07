package com.Mar5.beans;

public class Book {
    private int id;//书编号
    private String name;//书名
    private String author;//作者
    private double price;//价格
    private String press;//出版社
    private Kind kind;//种类
    private int number;

    static{

    }

    public Book() {
    }

    public Book(int id, String name, String author, double price, String press, Kind kind) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
        this.kind = kind;
    }

    public Book(int id, String name, String author, double price, String press, Kind kind, int number) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
        this.kind = kind;
        this.number = number;
    }

    public Book(String name, String author, double price, String press, Kind kind, int number) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
        this.kind = kind;
        this.number = number;
    }

    public Book(String name, String author, double price, String press, Kind kind) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
        this.kind = kind;
    }
    //    public E get(E i){
//        if (i.getClass().toString().equals()) {
//            return getId();
//        }
//    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
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
                ", kind=" + kind +
                ", number=" + number +
                '}';
    }
}
