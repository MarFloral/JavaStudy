package com.Mar.beans2;

public class Computer {
    public void run(USB usb1, USB usb2){
        System.out.println("开机");
        //System.out.println("显示器运行");
        usb1.run();
        usb1.down();
        usb2.run();
        usb2.down();
        System.out.println("关机");
    }
}
