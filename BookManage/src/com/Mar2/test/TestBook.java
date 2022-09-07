package com.Mar2.test;

import com.Mar2.beans.Book;
import com.Mar2.dao.impl.BookDaoImpl;

import java.util.Scanner;

public class TestBook {
    public static void main(String[] args) {
        System.out.println("====欢迎来到图书管理系统====");
        //Book[] books = new Book[20];
        Scanner scanner = new Scanner(System.in);//数字类型
        Scanner scanner2 = new Scanner(System.in);//字符串
        BookDaoImpl bookDaoImpl = new BookDaoImpl();
        //int i = 0;//编号
        boolean b = true;
        a:while (b) {
            System.out.println("【1】图书添加\n【2】图书修改\n【3】图书查询\n【4】安全退出");
            System.out.print("输入数字1-4选择功能：");
            int num = scanner.nextInt();//输入图书馆功能
            switch (num) {
                case 1:
                    System.out.print("请输入图书名：");
                    String name = scanner2.nextLine();
                    System.out.print("请输入图书作者：");
                    String author = scanner2.nextLine();
                    System.out.print("请输入图书价格：");
                    double price = scanner.nextDouble();
                    System.out.print("请输入图书出版社：");
                    String press = scanner2.nextLine();
                    Book book = new Book(BookDaoImpl.i+1, name, author, price, press);
                    bookDaoImpl.addBook(book);
                    //i++;
                    break;
                case 2:
                    if (BookDaoImpl.i < 1) {
                        System.out.println("图书馆还没有书");
                        break;
                    }
//                    System.out.println("修改图书");
//                    System.out.println("【1】删除\n【2】修改数据\n【3】退出修改");
//                    System.out.print("输入数字1-3选择功能：");
//                    int num1 = scanner.nextInt();
//                    switch (num1){
//                        case 1:
//                            System.out.print("请输入要修改的书的编号：");
//                            int c = scanner.nextInt();
//
//                            break;
//                        case 2:
//                            break;
//                        case 3:
//                            break;
//                        default:
//                    }
                    System.out.print("请输入要修改的书的编号：");
                    int c = scanner.nextInt();
                    for (int j = 0; j < BookDaoImpl.i; j++) {
                        if (bookDaoImpl.getBooks(j) == null) {
                            continue;
                        }
                        if (c == j + 1) {
                            System.out.println(bookDaoImpl.getBooks(j).toString());
                            System.out.println("【1】删除\n【2】修改数据\n【3】退出修改");
                            System.out.print("输入数字1-3选择功能：");
                            int num2 = scanner.nextInt();
                            switch (num2){
                                case 1:
                                    bookDaoImpl.deleteBook(j);
                                    break;
                                case 2:
                                    bookDaoImpl.updateBook(j);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("输入错误！");
                            }
                        }else if (j == BookDaoImpl.i ){
                            System.out.println("该书不存在");
                        }
                    }
//                    System.out.print("请输入要修改的书名：");
                    break;
                case 3:
                    System.out.println("图书查询");
                    System.out.print("请输入要查询的书的编号（输入0查询全部并自动退出查询,输入-1退出查询）：");
                    int a = scanner.nextInt();
                    bookDaoImpl.getBook(a);
                    break;
                case 4:
                    System.out.println("欢迎下次再来");
                    break a;
                default:
                    System.out.println("输入错误！");
                    break;
            }
        }
    }
}
