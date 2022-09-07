package com.Mar.controller;

import com.Mar.beans.G_Equipment;
import com.Mar.dao.G_EquipmentDao;
import com.Mar.dao.G_RecordsDao;
import com.Mar.dao.G_UserDao;
import com.Mar.dao.impl.G_EquipmentDaoImpl;
import com.Mar.dao.impl.G_RecordsDaoImpl;
import com.Mar.dao.impl.G_UserDaoImpl;
import com.Mar.service.G_EquipmentService;
import com.Mar.service.G_RecordsService;
import com.Mar.service.G_UserService;
import com.Mar.service.impl.G_EquipmentServiceImpl;
import com.Mar.service.impl.G_RecordsServiceImpl;
import com.Mar.service.impl.G_UserServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentController {
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串

    G_EquipmentService equipmentService = new G_EquipmentServiceImpl();

    boolean b = true;

    public void equipment() {
        System.out.println("【1】器材添加\n【2】器材修改\n【3】器材查询\n【4】安全退出");
        System.out.print("输入数字1-4选择功能：");
        int num = scanner.nextInt();//输入图书馆功能
        switch (num) {
            case 1:
                add();
                equipment();
            case 2:
                update();
                equipment();
            case 3:
                select();
                equipment();
            case 4:
                UserController userController = new UserController();
                userController.login();
            default:
                System.out.println("输入错误！");
                equipment();
        }
    }

    private void select() {
        ArrayList<G_Equipment> equipments = equipmentService.getEquipment();
        for (G_Equipment equipment : equipments){
            System.out.println(equipment);
        }
    }

    private void update() {
        System.out.println("修改器材");
        System.out.println("【1】删除\n【2】修改数据\n【3】退出修改");
        System.out.print("输入数字1-3选择功能：");
        int num1 = scanner.nextInt();
        switch (num1) {
            case 1:
                System.out.print("请输入要删除的器材编号：");
                int n = scanner.nextInt();
                equipmentService.delete(n);
                break;
            case 2:
                upata();
                break;
            case 3:
                System.out.println("退出成功");
                break;
            default:
                System.out.println("输入错误！");
        }
    }

    private void upata() {
        System.out.print("请输入要修改的器材编号：");
        int n = scanner.nextInt();
        System.out.print("输入修改后的器材名：");
        String name = scanner2.nextLine();
        G_Equipment equipment = new G_Equipment(n,name,null);
        equipmentService.updateEquipment(equipment);
        System.out.println("==修改成功==");
    }

    private void add() {
        System.out.println("器材添加");
        System.out.print("请输入器材名：");
        String name = scanner2.nextLine();
        G_Equipment equipment = new G_Equipment(name,null);
        equipmentService.addEquipment(equipment);
    }

}
