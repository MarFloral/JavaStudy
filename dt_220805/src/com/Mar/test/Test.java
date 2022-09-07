package com.Mar.test;

import com.Mar.beans.*;

public class Test {
    public static void main(String[] args) {
        Sale sale = new Sale();
        Phone phone = new Phone(1, "华为", "银色", 1234);
        Computer computer = new Computer(1, "联想", "银色", 4567);
        Ipad ipad = new Ipad(1, "小米", "黑色", 7890);
        TV tv = new TV(1, "小米", "白色", 14256);
//        boolean a = phone instanceof Goods;
//        System.out.println(a);
        sale.sale(phone);
        sale.sale(computer);
        sale.sale(ipad);
        sale.sale(tv);
    }
}
