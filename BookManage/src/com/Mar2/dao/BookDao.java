package com.Mar2.dao;

import com.Mar2.beans.Book;

public interface BookDao {
    //增加方法
    void addBook(Book book);
    //删除方法
    void deleteBook(int id);
    //修改方法
    void updateBook(int j);
    //查询方法
    void getBook(int i);
}
