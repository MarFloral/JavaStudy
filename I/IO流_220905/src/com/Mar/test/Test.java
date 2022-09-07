package com.Mar.test;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        //字节流输出流
        //创建好输出流对象，指定好文件，加true追加到后面，不写默认覆写
        OutputStream os = new FileOutputStream("D:\\aaa.text",true);
        //要写入的字符串
        String string = "123松下问童子，言师采药去。只在此山中，云深不知处。";//写入文件吧字符串转换成字节数组
        os.write(string.getBytes());
        //关闭流
        os.close();

        //字节流输入流
        InputStream in = new FileInputStream("D:\\aaa.text");
        //一次性取多少个字节
        byte[] bytes = new byte[1024];
        //用来接收读取的字节数组
        StringBuilder sb = new StringBuilder();
        //读取到的字节数组长度，为-1时表示没有数据
        int length = 0;
        //循环取数据
        while ((length = in.read(bytes)) != -1) {
            //将读取的内容转换成字符串
            sb.append(new String(bytes, 0, length));
        }
        //关闭流
        in.close();
        System.out.println(sb);
    }
}
