package com.Mar.test;

import java.io.*;

/**
 * @Auther: 老白
 * @Date: 2022/7/8
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {

//            //输入流
//            FileInputStream fileInputStream = new FileInputStream("D:\\aaa.txt");
//
//          byte[] b = new byte[1024];
//        int read = fileInputStream.read(b);
//
//        fileInputStream.read(b,0,read);
//
//        for (int i = 0;i<b.length;i++){
//            System.out.println(b[i]);
//        }
//
//        System.out.println();

        how();
    }



    public static void add(){
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new FileInputStream("D:\\aaa.txt"), "UTF-8");
            // 字符数组：一次读取多少个字符
            char[] chars = new char[1024];
            // 每次读取的字符数组先append到StringBuilder中
            StringBuilder sb = new StringBuilder();
            // 读取到的字符数组长度，为-1时表示没有数据
            int length;
            // 循环取数据
            while ((length = isr.read(chars)) != -1) {
                // 将读取的内容转换成字符串
                sb.append(chars, 0, length);
            }
            System.out.println(sb);
            // 关闭流
            isr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //转换流
    public  static void  ow(){

        try {
            //字节输出流
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\aaa.txt",true);

                //字符输出流
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");

            String str1 = "333江东大小乔很漂亮";

            outputStreamWriter.write(str1);

            outputStreamWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //缓冲字符流
    public  static void  how(){

//        try {
//            FileReader fileReader = new FileReader("D:\\aaa.txt");
//
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            String str = null;
//
//            while ((str = bufferedReader.readLine()) != null){
//                System.out.println(str);
//            }
//
//            bufferedReader.close();

//            FileWriter fileWriter = new FileWriter("D:\\aaa.txt", true);
//
//            FileOutputStream inputStream = new FileOutputStream("D:\\aaa.txt");
//
//            BufferedOutputStream bufferedWriter = new BufferedOutputStream(inputStream);
//
//            bufferedWriter
//            bufferedWriter.write("哥");
//            bufferedWriter.newLine();
//            bufferedWriter.write("你敢");
//            bufferedWriter.newLine();
//            bufferedWriter.write("你敢不写作业吗？");
//            bufferedWriter.newLine();
//
//            bufferedWriter.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//
//        try {
//            PrintStream ps=new PrintStream("D:\\aaa.txt");
//
//            ps.println("12321321");
//            System.out.println();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


        try {
            FileReader fileReader = new FileReader("D:\\aaa.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            FileWriter fileWriter = new FileWriter("D:\\ccc.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            String str = null;
            while ((str=bufferedReader.readLine()) !=null){
                System.out.println(str);
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过输入流得到字符串   吧这个字符串输出到一个文件中
     */

}
