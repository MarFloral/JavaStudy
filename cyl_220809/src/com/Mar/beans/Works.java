package com.Mar.beans;

public class Works {
    private String str;

    public Works() {
    }

    public Works(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String book(Works book, String id){
        int i = book.str.indexOf(id) + id.length() + 1;//起始值
        int i1 = book.str.indexOf("<", i);//结束值
        return book.str.substring(i,i1);
    }
}
