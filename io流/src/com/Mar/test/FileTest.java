package com.Mar.test;

import java.io.File;

public class FileTest {


    public static void main(String[] args) {


        //输入


        //输出


        int i ;//先把文件的内容输入给i

        
        File file = new File("D:\\aaa.txt");
        System.out.println(file);
        System.out.println("===========================");
        ///File对象所表示的文件或目录是否存
        boolean exists = file.exists();
        System.out.println(exists);
        System.out.println("===========================");

        ////获取文件名或路径名
        String name = file.getName();
        System.out.println(name);
        System.out.println("===========================");

        //查询文件名/路径
        String path = file.getPath();
        System.out.println(path);

        //查询父目录
        String parent = file.getParent();
        System.out.println(parent);

        //返回文件的长度
        long length = file.length();
        System.out.println(length);
        System.out.println("===========================");

        System.out.println(file.canWrite());
        System.out.println(file.canRead());
    }
}
