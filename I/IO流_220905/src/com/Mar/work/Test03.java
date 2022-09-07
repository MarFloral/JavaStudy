package com.Mar.work;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        FileReader fileReader = new FileReader("D:\\奥运年份表.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = null;
        while ((string = bufferedReader.readLine()) != null){
            strings.add(string);
        }

        while (true){
            System.out.print("输入年份：");
            String year = scanner.next();
            try {
                int i = Integer.parseInt(year);
            }catch (NumberFormatException e){
                System.out.println("请输入正确的数值");
                continue;
            }

            boolean b = true;
            for (String str : strings){
                if (str.substring(0,4).equals(year)){
                    String out = str.substring(5);
                    System.out.println(out);
                    b = false;
                }
            }
            if (b){
                System.out.println("该年份没有比赛");
            }else {
                break;
            }
        }
        fileReader.close();
        bufferedReader.close();
    }
}
