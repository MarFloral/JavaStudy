package com.Mar.test;

import java.io.*;

public class test03 {
    public static void main(String[] args) throws IOException {
//        //打印流
//        PrintWriter printWriter = new PrintWriter("D:\\eee.text");
//        System.out.println();
//        printWriter.print("123松下问童子");
//        printWriter.flush();
//        printWriter.close();

//        File file = new File("D:\\eee.text");
//        FileWriter fileWriter = new FileWriter(file);
//        fileWriter.write("13松下问童子");
//        fileWriter.close();



        //当前文件名加路径
        File file = new File("D:\\eee.text");
        System. out. println(file);
        System. out. println("=====================");

        //File对象所表示的文件或目录是否存在
        boolean exists =file.exists();
        System. out. println(exists);System. out. println("=====================");

        //获取文件名或路径名
        String name = file.getName();
        System.out. println (name) ;
        System. out. println("=====================");

        //查询文件名/路径
        String path = file.getPath();
        System. out. println(path);
        System. out. println("=====================");

        //查询父目录
        String parent = file.getParent();
        System.out.println (parent);
        System. out. println("=====================");

        //返回文件的长度
        long length = file.length();
        System. out. println(length);
        System. out. println("=====================");

        //是否是目录
        System.out.println(file.isDirectory());

        //判断读写权限
        System. out. println(file.canWrite());
        System. out. println(file.canRead());

    }
}
