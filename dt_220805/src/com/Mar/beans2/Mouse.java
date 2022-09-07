package com.Mar.beans2;

public class Mouse implements USB {
    @Override
    public void run() {
        System.out.println("连接鼠标的USB");
    }

    @Override
    public void down() {
        System.out.println("断开鼠标的USB");
    }
}
