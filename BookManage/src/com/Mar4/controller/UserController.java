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
import com.Mar4.service.RecordsService;
import com.Mar4.service.UserService;
import com.Mar4.service.impl.BookServiceImpl;
import com.Mar4.service.impl.RecordsServiceImpl;
import com.Mar4.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
    BookDao bookDaoImpl = new BookDaoImpl();
    KindDao kindDao = new KindDaoImpl();
    UserDao userDao = new UserDaoImpl();
    UserService userService = new UserServiceImpl();
    BookService bookService = new BookServiceImpl();
    RecordsService recordsService = new RecordsServiceImpl();
    BookController bookController = new BookController();
    KindController kindController = new KindController();
    RecordsController recordsController = new RecordsController();

    public void login() {
        System.out.println("====欢迎来到图书管理系统====");
        boolean b = true;
        User access = userLogin();//登录，注册
        if (access == null) {
            System.out.println("欢迎下次再来");
        } else if (access.getAccess().equals("管理员")) {//管理员
            guanliyuan();
        } else if (access.getAccess().equals("会员")) {//会员
            huiyuan(access);

        }
    }

    private void huiyuan(User access) {
        System.out.println("【1】全部图书\n【2】借书\n【3】还书\n【4】借书记录\n【5】安全退出");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                System.out.println("查询图书");
                ArrayList<Book> books = bookService.getBook(0);
                for (Book book : books) {
                    System.out.println(book);
                }
                huiyuan(access);
            case 2:
                System.out.println("借书");
                recordsController.recode(access);
                huiyuan(access);
            case 3:
                System.out.println("还书");
                recordsController.back(access);
                huiyuan(access);
            case 4:
                System.out.println("借书记录");
                ArrayList<Records> records = recordsService.select(access);
                if (records.size() == 0) {
                    System.out.println("暂无记录");
                } else {
                    for (Records record : records) {
                        System.out.println(record);
                    }
                }
                huiyuan(access);
            case 5:
                System.out.println("安全退出");
                login();
                break;
            default:
                System.out.println("输入错误！");
                huiyuan(access);
        }
    }

    private void guanliyuan() {
        System.out.println("【1】图书操作\n【2】类型操作\n【3】安全退出");
        System.out.print("输入数字1-3选择功能：");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                bookController.book();
                guanliyuan();
            case 2:
                kindController.kind();
                guanliyuan();
            case 3:
                System.out.println("欢迎下次再来");
                userLogin();
            default:
                System.out.println("输入错误！");
                guanliyuan();
        }
    }


    private User user() {    //输入语句
        while (true) {
            System.out.print("输入用户名：");
            String userName = scanner2.next();
            if (userService.decideUserName(userName)) {
                System.out.println("该用户名已存在！");
                continue;
            }
            System.out.print("输入密码：");
            String password = scanner2.next();
            User user = new User(userName, password);
            return user;
        }
    }

    public User userLogin() {
        System.out.println("【1】注册\n【2】登录\n【3】退出");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                boolean b = register();
                if (b) {
                    System.out.println("注册成功");
                    userLogin();
                }
                break;
            case 2:
                User user = logon();
                return user;
            case 3:
                return null;
            default:
                System.out.println("输入错误");
                userLogin();

        }
        return null;

    }

    private User logon() {//登录模块
        System.out.print("输入用户名：");
        String userName1 = scanner2.next();
        if (!userService.decideUserName(userName1)) {
            System.out.println("该用户名不存在");
            login();
        }
        System.out.print("输入密码：");
        String password1 = scanner2.next();
        User user = new User(userName1, password1);
        if (!userService.userLogin(user)) {
            System.out.println("密码错误");
            login();
        } else {
            System.out.println("登陆成功");
            //判断权限
            user.setAccess(userDao.getAccess(user));
            return user;
        }
        return null;
    }

    private boolean register() {//注册模块
        System.out.println("【1】注册管理员\n【2】注册会员\n【3】退出");
        int i1 = scanner.nextInt();
        switch (i1) {
            case 1:
                User user = user();
                user.setAccess("管理员");
                userDao.addUser(user);
                return true;
            case 2:
                User user1 = user();
                user1.setAccess("会员");
                userDao.addUser(user1);
                return true;
            case 3:
                System.out.println("退出成功");
                return false;
            default:
                return false;
        }
    }

}
