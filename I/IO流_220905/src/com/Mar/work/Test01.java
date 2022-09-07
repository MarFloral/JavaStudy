package com.Mar.work;

import java.io.*;

public class Test01 {//字节流复制文件
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\ddd.text");
        int length = (int) file.length();
        InputStream in = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        int a = 0;
        byte[] bytes = new byte[length];
        FileOutputStream out = new FileOutputStream("D:\\ddd2.text");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
        while ((a = bufferedInputStream.read(bytes, 0, length)) != -1) {
            bufferedOutputStream.write(bytes,0,length);
        }
        bufferedOutputStream.flush();
        in.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
