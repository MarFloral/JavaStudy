package com.Mar.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateText {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        //已过时方法
//        System.out.println((date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
//        System.out.println(date.getYear() + 1900);
//        System.out.println(date.getMonth() + 1);
//        System.out.println(date.getDate());

        //日期格式化类
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sf.format(date);
        System.out.println(format);

        sf.applyLocalizedPattern("2022.8.17 15.30.20");
        System.out.println(sf.format(date));
    }
}
