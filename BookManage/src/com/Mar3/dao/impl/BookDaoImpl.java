package com.Mar3.dao.impl;


import com.Mar3.beans.Book;
import com.Mar3.dao.BookDao;
import java.util.LinkedList;
import java.util.Scanner;

public class BookDaoImpl implements BookDao {
    //privateBook[] books = new Book[20];
    public static LinkedList<Book> books = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串

    static {    //默认5本书
        books.add(new Book(1, "笑傲江湖", "金庸", 123, "新晚报"));
        books.add(new Book(2, "倚天屠龙记", "金庸", 321, "新晚报"));
        books.add(new Book(3, "鹿鼎记", "金庸", 231, "新晚报"));
        books.add(new Book(4, "神雕侠侣", "金庸", 132, "新晚报"));
        books.add(new Book(5, "连城诀", "金庸", 213, "新晚报"));
    }

    public static int i = books.size() + 1;

    @Override
    public void addBook(Book book) {
        books.add(book);
        i++;
    }

    public Book getBooks(int i) {
        return books.get(i);
    }


    @Override
    public void deleteBook(int id) {
        boolean b = true;
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("删除成功");
                b = true;
                break;
            }
            b = false;
        }
        if (!b) {
            System.out.println("查无此书");
        }
    }

    @Override
    public void updateBook(int i, Book b1) {
        for(Book b2 : BookDaoImpl.books){
            if(b2.getId() == i){
                b1.setId(b2.getId());
                books.set(i - 1, b1);
            }
        }
    }

    @Override
    public boolean isExist(Book book) {
        return books.contains(book);
    }

    @Override
    public void getBook(int id) {
        if (id == 0) {
            for (Book book : books) {
                System.out.println(book.toString());
            }
        } else if (id == -1) {
        } else if (id < -1) {
            System.out.println("请输入正确的数值！");
        } else {

            boolean a = false;
            for (Book book : books) {
                if (book.getId() == id) {
                    a = true;
                    System.out.println(book.toString());
                    break;
                }
            }
            if (!a)
                System.out.println("该书不存在");
        }
    }
}
