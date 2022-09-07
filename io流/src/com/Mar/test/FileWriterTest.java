package com.Mar.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    public static void main(String[] args) throws IOException {



        //创建文件对象    有true  就是允许追加  若是false就是覆盖
            FileWriter fileWriter = new FileWriter("D:\\aaa.txt");

            String str = "";

              String str1 = "江东大小乔很漂亮";

            char[]  c = {'你','好','吗'};

            System.out.println(str);

            //输出到文件
//            fileWriter.write(c,0 , 1);
        fileWriter.write(str);
//        fileWriter.write(str1);


            //刷新
            fileWriter.flush();
            //关流
            fileWriter.close();

    }
}
