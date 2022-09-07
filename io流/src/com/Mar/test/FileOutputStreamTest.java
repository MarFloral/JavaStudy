package com.Mar.test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//字节输出
public class FileOutputStreamTest {

    public static void main(String[] args) {


        try {
            //创建对象
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\bbb.txt",true);
//            OutputStream os = new FileOutputStream(file, true);

//            fileOutputStream.write(65);
//            fileOutputStream.write(66);
//            fileOutputStream.write(67);

            String str = "222五虎上将前来报到，军师有何指示";

            String str1 = "江东大小乔很漂亮";

            byte[] b  = str.getBytes();
            byte[] b1  = str1.getBytes();

            fileOutputStream.write(b);
//            fileOutputStream.write(b1);

            fileOutputStream.flush();
            fileOutputStream.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
