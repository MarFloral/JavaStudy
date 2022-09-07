package com.Mar.beans2;

public class KeyBoard implements USB {
    @Override
    public void run() {
        System.out.println("连接键盘的USB");
    }
    @Override
    public void down() {
        System.out.println("断开键盘的USB");
    }
}
