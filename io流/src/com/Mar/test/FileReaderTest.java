package com.Mar.test;




import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

//字符输入流
public class FileReaderTest {

    public static void main(String[] args) throws IOException {

        //创建一个输入流的对象
        FileReader fileReader = new FileReader("D:\\aaa.txt");

        //创建一个字符数组
        char[]   c  = new char[2048];
        //读所有
//        int read =fileReader.read();///读完没有处理，会一直阻塞
//        System.out.println((char) read);

        String sb = "";
        // 读取到的字符数组长度，为-1时表示没有数据
        int length;
        // 循环取数据
        while ((length = fileReader.read(c)) != -1) {
            // 将读取的内容转换成字符串
            sb = new String(c, 0, length);

        }

        System.out.println(sb);
          //39118   只执行了一次
//        int read=fileReader.read();
//        int read1=fileReader.read();
//
//        System.out.println(read);
//        System.out.println(read1);


        //输出
        FileWriter fileWriter = new FileWriter("D:\\aaa1.txt",true);

        String str = "111江东大小乔很漂亮";
        fileWriter.write(str);
//        int read;
//        //读取字符  39118
//        while ( (read=fileReader.read()) != -1){
////            System.out.println(read);
//            System.out.print((char)read);
//
//            fileWriter.write((char)read);
//        }
//
//        System.out.println(read);
//
//        fileReader.read(c,0 ,10);
//
//
//        System.out.println(Arrays.toString(c));



        fileWriter.close();
        fileReader.close();

    }
}
