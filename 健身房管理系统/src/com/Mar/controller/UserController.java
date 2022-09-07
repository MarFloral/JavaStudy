package com.Mar.controller;

import com.Mar.beans.G_Equipment;
import com.Mar.beans.G_Records;
import com.Mar.beans.G_User;
import com.Mar.dao.G_UserDao;
import com.Mar.dao.impl.G_UserDaoImpl;
import com.Mar.service.G_EquipmentService;
import com.Mar.service.G_RecordsService;
import com.Mar.service.G_UserService;
import com.Mar.service.impl.G_EquipmentServiceImpl;
import com.Mar.service.impl.G_RecordsServiceImpl;
import com.Mar.service.impl.G_UserServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
    G_UserDao userDao = new G_UserDaoImpl();
    EquipmentController equipmentController = new EquipmentController();
    RecordsController recordsController = new RecordsController();
    G_UserService g_userService = new G_UserServiceImpl();
    G_RecordsService g_recordsService = new G_RecordsServiceImpl();
    G_EquipmentService g_equipmentService = new G_EquipmentServiceImpl();
    public void login() {
        System.out.println("====欢迎来到健身房管理系统====");
        boolean b = true;
        G_User access = userLogin();//登录，注册
        if (access == null) {
            System.out.println("欢迎下次再来");
            System.exit(1);
        } else if (access.getAccess().equals("管理员")) {//管理员
            guanliyuan();
        } else if (access.getAccess().equals("会员")) {//会员
            huiyuan(access);
        }
    }

    private void huiyuan(G_User user) {
        System.out.println("【1】全部器材\n【2】借用器材\n【3】归还器材\n【4】借用记录\n【5】安全退出");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                System.out.println("全部器材");
                ArrayList<G_Equipment> equipments = g_equipmentService.getEquipment();
                for (G_Equipment equipment : equipments) {
                    System.out.println(equipment);
                }
                huiyuan(user);
            case 2:
                System.out.println("借用器材");
                recordsController.recode(user);
                huiyuan(user);
            case 3:
                System.out.println("归还器材");
                recordsController.back(user);
                huiyuan(user);
            case 4:
                System.out.println("借用记录");
                ArrayList<G_Records> records = g_recordsService.select(user);
                if (records.size() == 0) {
                    System.out.println("暂无记录");
                } else {
                    for (G_Records record : records) {
                        System.out.println(record);
                    }
                }
                huiyuan(user);
            case 5:
                System.out.println("安全退出");
                //归还
                recordsController.back(user);
                login();
                break;
            default:
                System.out.println("输入错误！");
                huiyuan(user);
        }
    }

    private void guanliyuan() {
        System.out.println("【1】器材操作\n【2】安全退出");
        System.out.print("输入数字1-3选择功能：");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                equipmentController.equipment();
                guanliyuan();
            case 2:
                System.out.println("欢迎下次再来");
                userLogin();
            default:
                System.out.println("输入错误！");
                guanliyuan();
        }
    }

    private G_User userLogin() {
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
                G_User user = logon();
                return user;
            case 3:
                return null;
            default:
                System.out.println("输入错误");
                userLogin();

        }
        return null;
    }

    private G_User logon() {//登录
        System.out.print("输入用户名：");
        String userName = scanner2.next();
        if (g_userService.getUserByName(userName) == null) {
            System.out.println("该用户名不存在");
            login();
        }
        System.out.print("输入密码：");
        String password1 = scanner2.next();
        G_User user = new G_User(userName, password1);
        user = g_userService.getUser(user);
        if (user == null) {
            System.out.println("密码错误");
            login();
        } else {
            System.out.println("登陆成功");
            return user;
        }
        return null;
    }

    private boolean register() {//注册
        System.out.println("【1】注册管理员\n【2】注册会员\n【3】退出");
        int i1 = scanner.nextInt();
        switch (i1) {
            case 1:
                G_User user = user();
                user.setAccess("管理员");
                g_userService.addUser(user);
                return true;
            case 2:
                G_User user1 = user();
                user1.setAccess("会员");
                g_userService.addUser(user1);
                return true;
            case 3:
                System.out.println("退出成功");
                return false;
            default:
                return false;
        }
    }

    private G_User user() {
        while (true) {
            System.out.print("输入用户名：");
            String userName = scanner2.next();
            if (g_userService.getUserByName(userName) != null) {
                System.out.println("该用户名已存在！");
                continue;
            }
            System.out.print("输入密码：");
            String password = scanner2.next();
            G_User user = new G_User(userName, password);
            return user;
        }
    }
}
