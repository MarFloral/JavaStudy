package com.Mar4.service;

import com.Mar4.beans.Book;

import java.util.ArrayList;

public interface BookService {

    void addBook(Book book);

    void deleteBook(int n);

    void updateBook(Book book);

    ArrayList<Book> getBook(int a);

    ArrayList<Book> getBook(String name);

    ArrayList<Book> getKBook(String kind);

    Book decideBook(int id);

    void down(int id);

    void up(int id);
}
