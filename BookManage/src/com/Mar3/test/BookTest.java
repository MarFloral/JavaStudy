package com.Mar3.test;



import com.Mar3.beans.Book;
import com.Mar3.dao.BookDao;
import com.Mar3.dao.impl.BookDaoImpl;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        System.out.println("====欢迎来到图书管理系统====");
        Scanner scanner = new Scanner(System.in);//数字类型
        Scanner scanner2 = new Scanner(System.in);//字符串
        BookDao bookDaoImpl = new BookDaoImpl();
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
                    Book book = new Book(BookDaoImpl.i, name, author, price, press);
                    bookDaoImpl.addBook(book);
                    break;
                case 2:
                    System.out.println("修改图书");
                    System.out.println("【1】删除\n【2】修改数据\n【3】退出修改");
                    System.out.print("输入数字1-3选择功能：");
                    int num1 = scanner.nextInt();
                    switch (num1){
                        case 1:
                            System.out.print("请输入要删除的书的编号：");
                            int n = scanner.nextInt();
                            bookDaoImpl.deleteBook(n);
                            break;
                        case 2:
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
                            Book book2 = new Book(name1,author1,price1,press1);
                            bookDaoImpl.updateBook(n2,book2);
                            System.out.println("==修改成功==");
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("输入错误！");
                    }
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
