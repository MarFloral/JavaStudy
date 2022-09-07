package com.Mar2.dao.impl;


import com.Mar2.beans.Book;
import com.Mar2.dao.BookDao;

import java.util.Scanner;

public class BookDaoImpl implements BookDao {
    public static int i = 0;
    private Book[] books = new Book[20];
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
    @Override
    public void addBook(Book book) {
        books[i] = book;
        i++;
    }

    public Book getBooks(int i) {
        return books[i];
    }


    @Override
    public void deleteBook(int id) {
        books[id] = null;
    }

    @Override
    public void updateBook(int j) {
        System.out.println("【0】更改整本书的数据（如果不写默认不改）【1】修改图书名\n【2】修改图书作者\n【3】修改图书价格\n【4】修改图书出版社\n【5】退出修改");
        System.out.print("输入数字0-4选择功能：");
        int num3 = scanner.nextInt();
        switch (num3){
            case 0:
                System.out.print("输入修改后的图书名：");
                String name1 = scanner2.nextLine();
                if (name1.length() > 0) {
                    books[j].setName(name1);
                }
                System.out.print("输入修改后的图书作者：");
                String author1 = scanner2.nextLine();
                if (author1.length() > 0) {
                    books[j].setAuthor(author1);
                }
                System.out.print("输入修改后的图书价格：");
                double price1 = scanner.nextDouble();
                if (String.valueOf(price1).length() > 0) {
                    books[j].setPrice(price1);
                }
                System.out.print("输入修改后的图书出版社：");
                String press1 = scanner2.nextLine();
                if (press1.length() > 0) {
                    books[j].setPress(press1);
                }
                break;
            case 1:
                System.out.print("输入修改后的图书名：");
                String name2 = scanner2.nextLine();
                books[j].setName(name2);
                break;
            case 2:
                System.out.print("输入修改后的图书作者：");
                String author2 = scanner2.nextLine();
                books[j].setAuthor(author2);
                break;
            case 3:
                System.out.print("输入修改后的图书价格：");
                double price2 = scanner.nextDouble();
                books[j].setPrice(price2);
                break;
            case 4:
                System.out.print("输入修改后的图书出版社：");
                String press2 = scanner2.nextLine();
                books[j].setPress(press2);
                break;
            case 5:
                break ;
            default:
                System.out.println("输入错误！");
                break;
        }
    }

    @Override
    public void getBook(int a) {
        a:for (int k = 0; k >=0 ; k++) {
            if (a == 0) {
                if (i == 0) {
                    System.out.println("图书馆还没有书！");
                }else {
                    for (int j = 0; j < i; j++) {
                        //System.out.println(j);
                        if (books[j] == null)
                            continue;
                        System.out.println(books[j].toString());
                    }
                }
                break;
            }else if (a == -1) {
                break;
            }else if (a < -1){
                System.out.println("请输入正确的数值！");
            }else {
                int j;
                for (j = 0; j < i; j++) {
                    if (books[j] == null) {
                        continue;
                    }
                    if (a == j + 1) {
                        System.out.println(books[j].toString());
                        break a;
                    }
                    if (j == i - 1){
                        System.out.println("该书不存在");
                        break a;
                    }
                }
            }
            //System.out.print("请输入要查询的书的编号：");
        }
        //return new Book[0];
    }
}
