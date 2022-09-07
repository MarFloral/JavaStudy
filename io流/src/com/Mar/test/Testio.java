package com.Mar.test;

import java.io.*;

/**
 * @Auther: 老白
 * @Date: 2022/9/5
 * @Description:
 */
public class Testio {


    public static void main(String[] args) throws IOException {
//        //字节流输出流
//        //创建好输出流对象，指定好文件  不加true每次覆盖  加上true是追加到后面
//        OutputStream os = new FileOutputStream("D:\\aaa.txt",true);
//
//        // 要写入的字符串
//        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
//        // 写入文件  吧字符串转换成字节数组
//        os.write(string.getBytes());
//        // 关闭流
//        os.close();


//        字节输入流
        InputStream in = new FileInputStream("D:\\aaa.text");

        // 一次性取多少个字节
        byte[] bytes = new byte[1024];
        // 用来接收读取的字节数组  字符创
        StringBuilder sb = new StringBuilder();
        // 读取到的字节数组长度，为-1时表示没有数据
        int length = 0;
        // 循环取数据
        while ((length = in.read(bytes)) != -1) {
            // 将读取的内容转换成字符串
            sb.append(new String(bytes, 0, length));//截取
        }
//        in.read(bytes);//返回一个int  表示读取到多长的内容
//        sb.append(new String(bytes));
        // 关闭流
        in.close();

        System.out.println(sb);
    }
}
