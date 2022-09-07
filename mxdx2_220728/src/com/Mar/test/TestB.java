package com.Mar.test;

import com.Mar.beans.Book;

import java.util.Scanner;

public class TestB {
    public static void main(String[] args) {
        Book book = new Book();
        book.setPrice(100);
        System.out.println("价格："+book.getPrice());
        book.setId(1);
        System.out.println("编号："+book.getId());
        book.setName("环境");
        System.out.println("书名："+book.getName());
        book.setAuthor("七七");
        System.out.println("作者："+book.getAuthor());

        System.out.println();
        Book book1 = new Book();
        book1.setPrice(173.5);
        System.out.println("价格："+book1.getPrice());
        book1.setId(07);
        System.out.println("编号："+book1.getId());
        book1.setName("生命");
        System.out.println("书名："+book1.getName());
        book1.setAuthor("意义");
        System.out.println("作者："+book1.getAuthor());
        Scanner scanner = new Scanner(System.in);
    }
}
