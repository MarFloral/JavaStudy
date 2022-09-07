package com.Mar4.controller;

import com.Mar4.beans.Kind;
import com.Mar4.dao.BookDao;
import com.Mar4.dao.KindDao;
import com.Mar4.dao.UserDao;
import com.Mar4.dao.impl.BookDaoImpl;
import com.Mar4.dao.impl.KindDaoImpl;
import com.Mar4.dao.impl.UserDaoImpl;
import com.Mar4.service.KindService;
import com.Mar4.service.UserService;
import com.Mar4.service.impl.KindServiceImpl;
import com.Mar4.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class KindController {
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
    BookDao bookDaoImpl = new BookDaoImpl();
    KindDao kindDao = new KindDaoImpl();
    UserDao userDao = new UserDaoImpl();
    UserService userService = new UserServiceImpl();
    KindService kindService = new KindServiceImpl();
    boolean b = true;

    public void kind(){
        System.out.println("【1】类型添加\n【2】类型修改\n【3】类型查询\n【4】安全退出");
        System.out.print("输入数字1-4选择功能：");
        int num = scanner.nextInt();
        switch (num){
            case 1:
                addKind();
                break;
            case 2:
                updateKind();
                break;
            case 3:
                selectKind();
                break;
            case 4:
                break;
            default:

        }
    }

    private void selectKind() {
        System.out.println("类型查询");
        a:while (true) {
            System.out.println("【1】按编号查询\n【2】查询全部\n【3】退出");
            System.out.println("请输入查询方式：");
            int num2 = scanner.nextInt();
            switch (num2) {
                case 1:
                    System.out.print("请输入要查询的类型编号：");
                    int a = scanner.nextInt();
                    kindService.getKind(a);
                    break a;
                case 2:
                    System.out.println("已拥有的类型有：");
                    ArrayList<Kind> kinds = kindService.getKind();
                    for (Kind kind : kinds){
                        System.out.println(kind);
                    }
                    break a;
                case 3:
                    System.out.println("退出查询");
                    break a;
                default:
                    System.out.println("输入错误！");
                    break;
            }
        }
    }

    private void updateKind() {
        System.out.println("修改类型");
        System.out.println("【1】删除\n【2】修改数据\n【3】退出修改");
        System.out.print("输入数字1-3选择功能：");
        int num1 = scanner.nextInt();
        switch (num1) {
            case 1:
                System.out.print("请输入要删除的类型编号：");
                int n = scanner.nextInt();
                kindService.deleteKind(n);
                break;
            case 2:
                System.out.print("请输入要修改的类型编号：");
                int n2 = scanner.nextInt();
                System.out.print("输入修改后的类型名：");
                String name1 = scanner2.nextLine();
                Kind kind = new Kind(n2,name1);
                kindService.updateKind(kind);
                break;
            case 3:
                break;
            default:
                System.out.println("输入错误！");
        }
    }

    private void addKind() {//类型添加
        while (true) {
            System.out.print("请输入图书类型：");
            String kind = scanner2.nextLine();
            Kind kind1;
            if (kindService.decideKind(kind)) {
                System.out.println("该类型已存在！请重新输入");
                continue;
            } else {
                kind1 = new Kind(kind);
            }
            kindService.addKind(kind1);
            break;
        }
    }


}
