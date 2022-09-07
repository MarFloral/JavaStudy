package com.Mar.test;

import java.io.*;

public class Test02 {
    public static void main(String[] args) throws IOException {
//        //字符输出流
//        //创建好输出流对象，指定好文件，加true追加到后面，不写默认覆写
//        FileWriter fileWriter = new FileWriter("D:\\bbb.text",true);
//        String string = "123松下问童子，言师采药去。只在此山中，云深不知处。";
//        fileWriter.write(string);
//        fileWriter.close();
//
//
//        //字符输入流
////        InputStreamReader isr = new InputStreamReader (new FileInputStream(file),"UTF-8");
//        FileReader isr = new FileReader(  "D:\\bbb.text");
//        //字符数组:一次读取多少个字符
//        char[] chars = new char [1024];
//        //每次读取的字符数组先append到StringBui lder中
//        StringBuilder sb = new StringBuilder ();
//        //读取到的字符数组长度，为-1时表示没有数据
//        int length;
//        //循环取数据
//        while ((length = isr.read(chars)) !=-1) {
//            System.out.println(length);
//            //将读取的内容转换成字符串
//            sb.append(chars, 0, length);
//        }
//        isr.close();
//        System.out.println(sb);


//        //字节流转换字符流流
//        //输出
//        //字节流
//        OutputStream outputStream = new FileOutputStream( "D:\\ccc.txt", true);
//        //转换字符流
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//        String string = "123松下问童子，言师采药去。只在此山中，云深不知处。";
//        outputStreamWriter.write(string);
//
//        //输入
//        FileInputStream filelnputStream = new FileInputStream( "D:\\a1.txt");
//        InputStreamReader inputStreamReader = new InputStreamReader(filelnputStream) ;


//        //缓冲流
//        Writer writer = new FileWriter("D:\\ddd.text");
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
//        bufferedWriter.write("12松下问童子");
//        bufferedWriter.newLine();//换行
//        bufferedWriter.write("123松下问童子");
//        bufferedWriter.newLine();
//        bufferedWriter.close();
//        writer.close();
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\ddd.text"));
//        String str = null;
//        while ((str=bufferedReader.readLine()) != null){
//            System.out. println(str);
//        }
////        String s = bufferedReader.readLine();
////        System.out.println(s);
////        String s1 = bufferedReader.readLine();
////        System.out.println(s1);
////        String s2 = bufferedReader.readLine();
////        System.out.println(s2);
//        bufferedReader.close();

        //读写图片
        FileInputStream fileInputStream = new FileInputStream("D:\\123.jpg");
        File file = new File("D:\\123.jpg");
        int length =(int) file.length();
        System.out.println(file.length());
        byte[] bytes = new byte[length];
        System.out.println(bytes.toString());
        int read = fileInputStream.read(bytes);
        System.out.println(read);
        fileInputStream.read(bytes);
        System.out.println(bytes. toString());
        FileOutputStream fileOutputStream = new FileOutputStream( "D:\\12.jpg");
        fileOutputStream.write(bytes,0,read);
        fileOutputStream.close();
        fileInputStream. close();


    }
}
