package com.Mar5.dao;

import com.Mar5.beans.Book;

import java.util.ArrayList;

public interface BookDao {
    //增加方法
    void addBook(Book book);
    //删除方法
    void deleteBook(int id);
    //修改方法
    void updateBook(Book book);
    //

    //查询方法
    ArrayList<Book> getBook(int i);
    //依据书名查询（模糊查询）
    ArrayList<Book> getBook(String name);
    //依据类型查询
    ArrayList<Book> getKBook(String kind);

    Book decideBook(int id);

    void down(int id);

    void up(int id);
}
