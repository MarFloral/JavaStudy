package com.Mar.dao;

import com.Mar.beans.Book;

public interface BookDao {
    //增加方法
    void addBook(Book book);
    //删除方法
    void deleteBook(int id);
    //修改方法
    void updateBook(Book book);
    //查询方法
    Book[] getBook();
}
