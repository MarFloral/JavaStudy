package com.Mar.test;

import com.Mar.beans.Book;

import java.util.Arrays;
import java.util.Scanner;

public class TestBook {
    public static void main(String[] args) {
        System.out.println("====欢迎来到图书管理系统====");
        Book[] books = new Book[20];
        Scanner scanner = new Scanner(System.in);//数字类型
        Scanner scanner2 = new Scanner(System.in);//字符串
        int i = 0;//编号
        boolean b = true;
        a:while (b) {
            System.out.println("【1】图书添加\n【2】图书修改\n【3】图书查询\n【4】安全退出");
            System.out.print("输入数字1-4选择功能：");
            int num = scanner.nextInt();//输入图书馆功能
            switch (num) {
                case 1:
                    //编号
                    System.out.print("请输入图书名：");
                    String name = scanner2.nextLine();
                    System.out.print("请输入图书作者：");
                    String author = scanner2.nextLine();
                    System.out.print("请输入图书价格：");
                    double price = scanner.nextDouble();
                    System.out.print("请输入图书出版社：");
                    String press = scanner2.nextLine();
//                    Book book = new Book(i+1, name, author, price, press);
//                    books[i] = book;
                    books[i] = new Book(i+1, name, author, price, press);
                    i++;
//                    books[i].setId(i++);
//                    books[i].setName(name);
//                    books[i].setAuthor(author);
//                    books[i].setPrice(price);
//                    books[i].setPress(press);
                    break;
                    //存到对象中再存入数组
                case 2:
                    if (i < 1) {
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
                    for (int j = 0; j < i; j++) {
                        if (books[j] == null) {
                            continue;
                        }
                        if (c == j + 1) {
                            System.out.println("图书编号：" + books[j].getId() + "\n图书名：" + books[j].getName() + "\n图书作者：" + books[j].getAuthor() + "\n图书价格：" + books[j].getPrice() + "\n图书出版社：" + books[j].getPress() + "\n");
                            System.out.println("【1】删除\n【2】修改数据\n【3】退出修改");
                            System.out.print("输入数字1-3选择功能：");
                            int num2 = scanner.nextInt();
                            switch (num2){
                                case 1:
                                    System.out.println(j);
                                    for (int k = j; k < i; k++) {
                                            books[k] = null;
                                    }
                                    break;
                                case 2:
                                    System.out.println("【0】更改整本书的数据（如果不写默认不改）【1】修改图书名\n【2】修改图书作者\n【3】修改图书价格\n【4】修改图书出版社\n【5】退出修改");
                                    System.out.print("输入数字1-4选择功能：");
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
                                            if ( String.valueOf(price1).length() > 0) {
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
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("输入错误！");
                            }
                        }else if (j == i ){
                            System.out.println("该书不存在");
                        }
                    }
//                    System.out.print("请输入要修改的书名：");
                    break;
                case 3:
                    System.out.println("图书查询");
                    System.out.print("请输入要查询的书的编号（输入0查询全部并自动退出查询,输入-1退出查询）：");
                    for (int k = 0; k >=0 ; k++) {
                        int a = scanner.nextInt();
                        if (a == 0) {
                            if (i == 0) {
                                System.out.println("图书馆还没有书！");
                            }else {
                                for (int j = 0; j < i; j++) {
                                    //System.out.println(j);
                                    if (books[j] == null)
                                        continue;
                                    System.out.println("图书编号：" + books[j].getId() + "\n图书名：" + books[j].getName() + "\n图书作者：" + books[j].getAuthor() + "\n图书价格：" + books[j].getPrice() + "\n图书出版社：" + books[j].getPress() + "\n");
                                }
                            }
                            break;
                        }else if (a == -1) {
                            break;
                        }else if (a < -1){
                            System.out.println("请输入正确的数值！");
                        }else {
                            for (int j = 0; j < i; j++) {
                                if (books[j] == null) {
                                    continue;
                                }
                                if (a == j + 1) {
                                    System.out.println("图书编号：" + books[j].getId() + "\n图书名：" + books[j].getName() + "\n图书作者：" + books[j].getAuthor() + "\n图书价格：" + books[j].getPrice() + "\n图书出版社：" + books[j].getPress() + "\n");
                                }else if (j == i - 1){
                                    System.out.println("该书不存在");
                                }
                            }
                        }
                        System.out.print("请输入要查询的书的编号：");
                    }
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
