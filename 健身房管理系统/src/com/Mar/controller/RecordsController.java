package com.Mar.controller;

import com.Mar.beans.G_Equipment;
import com.Mar.beans.G_Records;
import com.Mar.beans.G_User;
import com.Mar.service.G_EquipmentService;
import com.Mar.service.G_RecordsService;
import com.Mar.service.G_UserService;
import com.Mar.service.impl.G_EquipmentServiceImpl;
import com.Mar.service.impl.G_RecordsServiceImpl;
import com.Mar.service.impl.G_UserServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class RecordsController {
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
    G_RecordsService recordsService = new G_RecordsServiceImpl();
    G_EquipmentService equipmentService = new G_EquipmentServiceImpl();

    public void recode(G_User user) {//借器材
        System.out.println("输入器材id");
        int id = scanner.nextInt();
        G_Equipment equipment = equipmentService.getEquipmentById(id);
        if (equipment != null) {//器材存在
            //判断是否被使用
            String status = equipment.getStatus();
            if (status.equals("闲置中")) {
                //判断是否有未还的
                G_Records record = recordsService.getRecord(user);
                if (record == null){//没有未还的
                    recordsService.addRecords(user, equipment);//改状态，加记录
                }else {//有未还的
                    //先还
                    back(user);
                    recordsService.addRecords(user, equipment);
                }
            } else {
                System.out.println("正在使用中");
            }
        }else {
            System.out.println("没有此器材");
            recode(user);
        }
    }

    public void back(G_User user) {//还
        //直接修改
        recordsService.updateBtime(user);
    }

    //查看书，借书，还书，借书记录


}
