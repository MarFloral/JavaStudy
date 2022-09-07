package com.Mar.test;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FileInputStreamTest {
    //字节输入流
    public static void main(String[] args) {

        try {

            FileInputStream fileInputStream = new FileInputStream("D:\\aaa.txt");

            InputStreamReader isr = new InputStreamReader(fileInputStream,"UTF-8");

//            int read = fileInputStream.read();
            byte[] b  = new byte[1024];

//            int read1 = isr.read();
//            int read = fileInputStream.read();
//            System.out.println((char) read1);
                int n;
//            while ((n=isr.read()) != -1){
//                System.out.print((char) n);//97
//            }
//            System.out.println(fileInputStream.read(b));
            String s = "";
            while ((n = fileInputStream.read(b)) != -1) {
                System.out.println(n);
                // 将读取的内容转换成字符串
                 s = new String(b, 0, n);
            }

            System.out.println(s);
//            System.out.println("----------");
                char[] c = new char[1024];
//            isr.read(c);

            //读取到byte数组
//            fileInputStream.read(b);
//            String str = new String(b);
//            System.out.println(str);

//            byte[] b1 = new byte[12];
//            fileInputStream.read(b1);
//            ;  String str1 = new String(b1);
//            System.out.println(str1);

            //关流
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void add(byte[] b) {
        b[0]=23;
    }
}
