package com.Mar5.service.impl;

import com.Mar5.beans.Book;
import com.Mar5.dao.BookDao;
import com.Mar5.dao.impl.BookDaoImpl;
import com.Mar5.service.BookService;

import java.util.ArrayList;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();


    @Override
    public void addBook(Book book) {//添加
        bookDao.addBook(book);
    }//添加图书

    @Override
    public void deleteBook(int n) {//删除
        bookDao.deleteBook(n);
    }//删除

    @Override
    public void updateBook(Book book) {//修改
        bookDao.updateBook(book);
    }

    @Override
    public ArrayList<Book> getBook(int a) {//id查书
        return bookDao.getBook(a);
    }//id查书

    @Override
    public ArrayList<Book> getBook(String name) {//书名查书
        return bookDao.getBook(name);
    }//书名查书

    @Override
    public ArrayList<Book> getKBook(String kind) {//种类查书
        return bookDao.getKBook(kind);
    }//种类查书

    @Override
    public Book decideBook(int id) {//判断书存在
        return bookDao.decideBook(id);
    }

    @Override
    public void down( int id) {
        bookDao.down(id);
    }

    @Override
    public void up(int id) {
        bookDao.up(id);
    }
}
