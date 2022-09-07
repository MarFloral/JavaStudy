package com.Mar4.beans;

import java.util.ArrayList;

public class Kind {
    private int bid;
    private String bname;
    private ArrayList<Book> books;

    public Kind() {
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Kind(int bid, String bname) {
        this.bid = bid;
        this.bname = bname;
    }

    public Kind(String bname) {
        this.bname = bname;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        if (bname == null){
            return "无";
        }else {
            return bname;
        }
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        if (bname == null){
            return "无";
        }else {
            return bname;
        }
    }
}
