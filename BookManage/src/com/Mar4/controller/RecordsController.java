package com.Mar4.controller;

import com.Mar4.beans.Book;
import com.Mar4.beans.Records;
import com.Mar4.beans.User;
import com.Mar4.dao.BookDao;
import com.Mar4.dao.KindDao;
import com.Mar4.dao.UserDao;
import com.Mar4.dao.impl.BookDaoImpl;
import com.Mar4.dao.impl.KindDaoImpl;
import com.Mar4.dao.impl.UserDaoImpl;
import com.Mar4.service.BookService;
import com.Mar4.service.KindService;
import com.Mar4.service.RecordsService;
import com.Mar4.service.UserService;
import com.Mar4.service.impl.BookServiceImpl;
import com.Mar4.service.impl.KindServiceImpl;
import com.Mar4.service.impl.RecordsServiceImpl;
import com.Mar4.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class RecordsController {
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
    BookDao bookDaoImpl = new BookDaoImpl();
    KindDao kindDao = new KindDaoImpl();
    UserDao userDao = new UserDaoImpl();
    UserService userService = new UserServiceImpl();
    KindService kindService = new KindServiceImpl();
    BookService bookService = new BookServiceImpl();
    RecordsService recordsService = new RecordsServiceImpl();

    public void recode(User user) {//借书
        System.out.println("输入图书id");
        int id = scanner.nextInt();
        Book book1 = bookService.decideBook(id);
        if (book1 != null) {
            //判断数量
            int num = book1.getNumber();
            if (num > 0) {
                //判断是否已借
                ArrayList<Records> records = recordsService.select(user);
                for (Records record : records) {
                    if (record.getBname().equals(book1.getName()) && record.getBtime() == null) {
                        System.out.println("该书已借过");
                        return;
                    }
                }

                ArrayList<Book> books = bookService.getBook(id);
                for (Book book : books) {
                    recordsService.add(user, book.getName());
                }
//                ArrayList<Records> records = recordsService.select(user);
//                for (Records record : records){
//
//                }
                //添加记录

                //减少数量
                bookService.down(id);
                System.out.println("借书成功");
            } else {
                System.out.println("本书库存不足");
            }

        } else {
            System.out.println("查无此书");
            recode(user);
        }

    }

    public void back(User user) {
        ArrayList<Records> records = recordsService.select(user);
        for (Records record : records) {
            if (record.getBtime() == null) {
                System.out.println(record);
            }
        }
        System.out.println("输入出借编号");
        int id = scanner.nextInt();
        boolean b = false;
        //加号
        for (Records record : records) {
            if (record.getBtime() == null && record.getId() == id) {
                ArrayList<Book> books = bookService.getBook(record.getBname());
                for (Book book : books) {
                    recordsService.down(id);
                    bookService.up(book.getId());

                    b = true;
                }
                break;
            }
        }
        if (b) {
            System.out.println("还书成功");
        } else {
            System.out.println("无此纪录或该书已还");
        }

    }

    //查看书，借书，还书，借书记录


}
