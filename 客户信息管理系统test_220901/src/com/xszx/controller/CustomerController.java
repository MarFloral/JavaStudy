package com.xszx.controller;

import com.xszx.beans.Customer;
import com.xszx.service.CustomerService;
import com.xszx.service.impl.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);//数字
    Scanner scanner2 = new Scanner(System.in);//字符串
    CustomerService customerService = new CustomerServiceImpl();

    public void login() {
        System.out.println("-----------------------客户信息管理软件-----------------------");
        System.out.println("\n\t\t\t\t\t\t1 添加客户\n\t\t\t\t\t\t2 修改客户\n\t\t\t\t\t\t3 删除客户\n\t\t\t\t\t\t4 客户列表\n\t\t\t\t\t\t5 退    出\n");
        System.out.print("\t\t\t\t\t\t请选择(1-5)：");
        int num = scanner.nextInt();
        switch (num) {
            case 1://添加客户
                add();
                login();
            case 2://修改客户
                update();
                login();
            case 3://删除客户
                delete();
                login();
            case 4://客户列表
                select();
                login();
            case 5://退出
                System.exit(1);
                break;
            default:
                System.out.println("输入错误");
                login();
        }
    }

    private void delete() {
        System.out.println("---------------------------删除客户---------------------------");
        System.out.println("请选择待删除客户编号(-1退出)∶");
        int num = scanner.nextInt();
        if (num == -1) {
            login();
        }else {
            Customer customer = customerService.selectById(num);
            if (customer == null) {
                System.out.println("该客户不存在");
            }else {
                System.out.println("确认是否删除(Y/N) : ");
                String a = scanner2.next();
                switch (a){
                    case "y":
                    case "Y":
                        customerService.delete(num);
                        System.out.println("---------------------------删除完成---------------------------");
                        login();
                    case "n":
                    case "N":
                        System.out.println("---------------------------退出完成---------------------------");
                        login();
                    default:
                        System.out.println("---------------------------输入错误---------------------------");
                        delete();
                }
            }
        }

    }

    private void update() {
        System.out.println("---------------------------修改客户---------------------------");
        System.out.println("请选择待修改客户编号(-1退出)∶");
        int num = scanner.nextInt();
        if (num == -1) {
            login();
        } else {
            Customer customer = customerService.selectById(num);
            if (customer == null) {
                System.out.println("该客户不存在");
            } else {
                System.out.print("姓名(" + customer.getNaem() + "):");
                String name = scanner2.nextLine();
                if (name.length() == 0) {//判断长度
                    name = customer.getNaem();
                }
                System.out.print("性别(" + customer.getSex() + "):");
                String sex = scanner2.nextLine();
                if (sex.length() == 0) {
                    sex = customer.getSex();
                }
                System.out.print("年龄(" + customer.getAge() + "):");
                String ages = scanner2.nextLine();
                int age;
                if (ages.length() == 0) {
                    age = customer.getAge();
                }else {
                    age = Integer.parseInt(ages);
                }
                System.out.print("电话(" + customer.getTel() + "):");
                String tel = scanner2.nextLine();
                if (tel.length() == 0) {
                    tel = customer.getTel();
                }
                System.out.print("邮箱(" + customer.getEmail() + "):");
                String email = scanner2.nextLine();
                if (email.length() == 0) {
                    email = customer.getEmail();
                }
                customer = new Customer(num, name, sex, age, tel, email);
                customerService.update(customer);
            }

        }
    }

    private void select() {
        System.out.println("---------------------------客户列表---------------------------");
        ArrayList<Customer> customers = customerService.select();
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println("--------------------------客户列表完成-------------------------");
    }

    private void add() {
        System.out.println("---------------------------添加客户---------------------------");
        System.out.print("姓名：");
        String name = scanner2.next();
        System.out.print("性别：");
        String sex = scanner2.next();
        System.out.print("年龄：");
        int age = scanner.nextInt();
        System.out.print("电话：");
        String tel = scanner2.next();
        System.out.print("邮箱：");
        String email = scanner2.next();
        Customer customer = new Customer(name, sex, age, tel, email);
        customerService.add(customer);//添加方法
        System.out.println("---------------------------添加完成---------------------------");
    }
}
