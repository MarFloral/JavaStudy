package com.Mar5.controller;

import com.Mar5.beans.Book;
import com.Mar5.beans.Records;
import com.Mar5.beans.User;
import com.Mar5.dao.UserDao;
import com.Mar5.dao.impl.UserDaoImpl;
import com.Mar5.service.BookService;
import com.Mar5.service.RecordsService;
import com.Mar5.service.UserService;
import com.Mar5.service.impl.BookServiceImpl;
import com.Mar5.service.impl.RecordsServiceImpl;
import com.Mar5.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
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
            guanliyuan(access);
        } else if (access.getAccess().equals("会员")) {//会员
            huiyuan(access);
        }
    }

    private void huiyuan(User access) {
        System.out.println("【1】全部图书\n【2】借书\n【3】还书\n【4】借书记录\n【5】个人信息\n【6】安全退出");
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
                System.out.println("个人信息操作");
                message(access);
                huiyuan(access);
            case 6:
                System.out.println("安全退出");
                login();
                break;
            default:
                System.out.println("输入错误！");
                huiyuan(access);
        }
    }

    private void message(User user) {
        System.out.println("【1】查询个人信息\n【2】修改密码\n【3】安全退出");
        int num = scanner.nextInt();
        switch (num){
            case 1:
                System.out.println(user);
                message(user);
            case 2:
                updatePassword(user);
                message(user);
            case 3:
                huiyuan(user);
            default:
                System.out.println("输入错误");
                message(user);

        }
    }

    private void updatePassword(User user) {
        System.out.println("输入要修改的密码");
        String password = scanner2.next();
        user.setPassword(password);
        int update = userService.update(user);
        System.out.println("修改成功");
    }

    private void guanliyuan(User user) {
        System.out.println("【1】图书操作\n【2】类型操作\n【3】会员操作\n【4】安全退出");
        System.out.print("输入数字1-3选择功能：");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                bookController.book();
                guanliyuan(user);
            case 2:
                kindController.kind();
                guanliyuan(user);
            case 3:
                glUser(user);
                guanliyuan(user);
            case 4:
                System.out.println("欢迎下次再来");
                userLogin();
            default:
                System.out.println("输入错误！");
                guanliyuan(user);
        }
    }

    private void glUser(User user) {
        System.out.println("【1】查看用户信息\n【2】注销用户\n【3】提升用户权限\n【4】重置用户密码（111）\n【5】退出");
        System.out.print("输入数字1-5选择功能：");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                ArrayList<User> users = userService.userSelect();
                for (User user1 : users) {
                    System.out.println(user1);
                }
                glUser(user);
            case 2:
                deleteUser(user);
                glUser(user);
            case 3:
                updateAccess(user);
                glUser(user);
            case 4:
                update(user);
                glUser(user);
            case 5:
                guanliyuan(user);
            default:
        }
    }

    private void update(User user) {
        System.out.println("输入要重置的用户编号");
        int id = scanner.nextInt();
        User user1 = new User();
        user1.setId(id);
        user1 = userService.getUser(user1);
        if (user1.getAccess().equals("管理员")) {
            System.out.println("不能修改管理员信息");
            glUser(user);
        } else {
            user1.setPassword("111");
            int a = userService.update(user1);
            if (a == 0){
                System.out.println("用户不存在");
                updateAccess(user);
            }else {
                System.out.println("修改成功");
            }
            glUser(user);
        }
    }

    private void updateAccess(User user) {
        System.out.println("输入要修改的用户编号");
        int id = scanner.nextInt();
        User user1 = new User();
        user1.setId(id);
        user1 = userService.getUser(user1);
        if (user1 == null){
            System.out.println("用户不存在");
            updateAccess(user);
        }else if (user1.getAccess().equals("管理员")) {
            System.out.println("不能修改管理员的权限");
            glUser(user);
        } else {
            user1.setAccess("管理员");
            userService.update(user1);
            glUser(user);
        }
    }


    private void deleteUser(User user) {
        System.out.println("请输入要注销的用户编号");
        int id = scanner.nextInt();
        User user1 = new User();
        user1.setId(id);
        user1 = userService.getUser(user1);
        if (user1 == null){
            System.out.println("没有该用户");
        }else if (user1.getAccess().equals("管理员")) {
            System.out.println("不能修改管理员的信息");
            glUser(user);
        } else {
            int delete = userService.delete(id);
        }
    }

    private void pd(User user) {
        System.out.println("是否注销个人账号（y/n）");
        String t = scanner2.next();
        switch (t) {
            case "Y":
            case "y":
                userService.delete(user.getId());
                login();
            case "N":
            case "n":
                deleteUser(user);
            default:
                System.out.println("输入错误");
                deleteUser(user);
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
                }
                userLogin();
            case 2:
                User user = logon();
                return user;
            case 3:
                System.exit(1);
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
            User user1 = userService.getUser(user);
            return user1;
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
