package com.Mar3.dao;

import com.Mar3.beans.Book;

public interface BookDao {
    //增加方法
    void addBook(Book book);
    //删除方法
    void deleteBook(int id);
    //修改方法
    void updateBook(int i,Book book);
    //查询方法
    void getBook(int i);
    //判断是否在集合中
    boolean isExist(Book book);
}
