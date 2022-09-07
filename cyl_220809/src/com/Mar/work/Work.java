package com.Mar.work;

import com.Mar.beans.Works;

import java.util.Scanner;

public class Work {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("输入大字符串");
//        String str1 = scanner.next();
//        System.out.print("输入小字符串");
//        String str2 = scanner.next();
//        int i = 0;//开始位置
//        int cont = 0;
//        //boolean b = true;
//        while (true) {
//            int i1 = str1.indexOf(str2, i);
//            if (i1 >= 0) {
//                cont += 1;
//                i = i1 + str2.length();
//                //System.out.println(cont + " " +i);
//            }else {
//                break;
//            }
//        }
//        System.out.println("共出现" + cont + "次");

        //String str = "<Book><id>1</id><name>笑傲江湖</name><author>金庸</author></Book>";

        Works book = new Works();
        book.setStr("<Book><id>1</id><name>笑傲江湖</name><author>金庸</author></Book>");
        String id = book.book(book, "id");
        String name = book.book(book, "name");
        String author = book.book(book, "author");
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        System.out.println("author:" + author);
        System.out.println(book.getStr().equals("<"));
    }
}
