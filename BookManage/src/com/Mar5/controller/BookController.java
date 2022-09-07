package com.Mar5.controller;

import com.Mar5.beans.Book;
import com.Mar5.beans.Kind;
import com.Mar5.dao.KindDao;
import com.Mar5.dao.impl.KindDaoImpl;
import com.Mar5.service.BookService;
import com.Mar5.service.KindService;
import com.Mar5.service.impl.BookServiceImpl;
import com.Mar5.service.impl.KindServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class BookController {
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
    KindDao kindDao = new KindDaoImpl();
    BookService bookService = new BookServiceImpl();
    KindService kindService = new KindServiceImpl();
    boolean b = true;

    private void add(){//添加
        System.out.println("图书添加");
        System.out.print("请输入图书名：");
        String name = scanner2.nextLine();
        System.out.print("请输入图书作者：");
        String author = scanner2.nextLine();
        System.out.print("请输入图书价格：");
        double price = scanner.nextDouble();
        System.out.print("请输入图书出版社：");
        String press = scanner2.nextLine();
        while (true) {
            ArrayList<Kind> kind1 = kindDao.getKind();
            for (Kind kind : kind1){
                System.out.println(kind);
            }
            System.out.print("请输入图书类型：");
            String kind = scanner2.nextLine();
            Book book;
            if (kindService.decideKind(kind)) {
                book = new Book(name, author, price, press, new Kind(kind));
            } else {
                System.out.println("请输入正确的类型！");
                continue;
            }
            bookService.addBook(book);
            break;
        }
    }

    public void book(){
        a:
        while (b) {
            System.out.println("【1】图书添加\n【2】图书修改\n【3】图书查询\n【4】安全退出");
            System.out.print("输入数字1-4选择功能：");
            int num = scanner.nextInt();//输入图书馆功能
            switch (num) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    select();
                    break;
                case 4:
                    break a;
                default:
                    System.out.println("输入错误！");
                    break;
            }
        }
    }

    private void select() {
        System.out.println("图书查询");
        System.out.println("【1】按编号查询\n【2】按书名查询（模糊查询）\n【3】查询类型的书\n【4】退出");
        System.out.println("请输入查询方式：");
        int num2 = scanner.nextInt();
        switch (num2) {
            case 1:
                selectById();
                break;
            case 2:
                selectByName();
                break;
            case 3:
                selectByKind();

            case 4:
                System.out.println("退出查询");
                break;
            default:
                System.out.println("输入错误！");
                select();
        }
    }

    private void selectByKind() {
        System.out.println("请输入要查询的类型");
        String kind = scanner2.nextLine();
        if (kindService.decideKind(kind)) {
            ArrayList<Book> books = bookService.getKBook(kind);
            if (books.size() != 0) {
                for (Book book : books) {
                    System.out.println(book);
                }
            }else {
                selectByKind();
            }
        } else {
            System.out.println("该类型不存在");
            selectByKind();
        }
    }

    private void selectByName() {
        System.out.println("请输入书名或其中一部分（输入“查询全部”时将查询所有书籍）：");
        String name1 = scanner2.nextLine();
        ArrayList<Book> books = bookService.getBook(name1);
        if (books.size() != 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        }else {
            selectByName();
        }
    }

    private void selectById() {
        System.out.print("请输入要查询的书的编号（输入0查询全部并自动退出查询,输入-1退出查询）：");
        int a = scanner.nextInt();
        ArrayList<Book> books = bookService.getBook(a);
        if (books.size() != 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        }else {
            selectById();
        }
    }

    private void update() {
        System.out.println("修改图书");
        System.out.println("【1】删除\n【2】修改数据\n【3】退出修改");
        System.out.print("输入数字1-3选择功能：");
        int num1 = scanner.nextInt();
        switch (num1) {
            case 1:
                System.out.print("请输入要删除的书的编号：");
                int n = scanner.nextInt();
                bookService.deleteBook(n);
                break;
            case 2:
                upata();
                break;
            case 3:
                System.out.println("退出成功");
                break;
            default:
                System.out.println("输入错误！");
        }
    }

    private void upata() {
        System.out.print("请输入要修改的书的编号：");
        int n2 = scanner.nextInt();
        System.out.print("输入修改后的图书名：");
        String name1 = scanner2.nextLine();
        System.out.print("输入修改后的图书作者：");
        String author1 = scanner2.nextLine();
        System.out.print("输入修改后的图书价格：");
        double price1 = scanner.nextDouble();
        System.out.print("输入修改后的图书出版社：");
        String press1 = scanner2.nextLine();
        System.out.print("请输入图书类型：");
        String kind1 = scanner2.nextLine();
        Book book1 = new Book(n2,name1, author1, price1, press1, new Kind(kind1));
        bookService.updateBook(book1);
        System.out.println("==修改成功==");
    }
}
