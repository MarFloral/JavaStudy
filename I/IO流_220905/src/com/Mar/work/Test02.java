package com.Mar.work;

import java.io.*;

public class Test02 {//字符流复制文件
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\ddd.text");
        int length = (int) file.length();
        FileReader in = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(in);
        int a = 0;
        char[] chars = new char[length];
        Writer out = new FileWriter("D:\\ddd3.text");
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        while ((a = bufferedReader.read(chars, 0, length)) != -1) {
            bufferedWriter.write(chars,0,length);
        }
        bufferedWriter.flush();
        in.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
