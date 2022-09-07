package com.Mar;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//1.定义一个用于存放班级分数的数组   int[] score = {80,90,85,90,78,88,89,93,98,75,59,40};
//  1)求不及格人数(小于60分)
//  2)总分
//  3)平均分
//2.猜数字游戏
//   程序运行，后台随机生成1-100之间的随机整数，控制台动态输入所猜的数字和随机数比较，并给出提示，猜大了还是猜小了
//   当正确猜出以后，程序结束，打印生成的随机数，并打印猜了多少局
//
//3.计算数组所有元素的和及平均值：随机生成10个整数，求和，打印输入
//4.使用数组做一副扑克牌，打印输出。
//5.熟练使用类的创建(成员属性、成员方法)，对象的实例，属性和方法的访问

public class Work {
    public static void main(String[] args) {
        //作业一
//        System.out.println("作业一");
//        int[] score = {80,90,85,90,78,88,89,93,98,75,59,40};
//        Arrays.sort(score);//排序
//        int cont = 0, sum = 0;//计数和求和
//        for (int i = 0; i < score.length; i++) {
//            if (score[i] < 60) {
//                cont++;
//            }
//            sum += score[i];
//        }
//        double avg = sum/score.length;//均值
//        System.out.println("有"+cont+"个人不及格");
//        System.out.println("总分为："+sum);
//        System.out.println("平均分为："+avg);

        //作业二
//        System.out.println("作业二");
//        Random random = new Random();
//        Scanner scanner = new Scanner(System.in);
//        int a = random.nextInt(100)+1;//生成随机数
//        int cont=0;//猜测次数
//        for (int i = 0; i < 100; i++) {
//            System.out.print("输入100以内数字：");
//            int b = scanner.nextInt();
//            cont++;
//            if (b > a) {
//                System.out.println("输入数字偏大！");
//            }else if (b < a) {
//                System.out.println("输入数字偏小！");
//            }else {
//                System.out.println("输入正确！该随机数为"+a);
//                System.out.println("共输入"+cont+"次");
//                break;
//            }
//        }

        //作业三
//        System.out.println("作业三");
//        Random random = new Random();
//        int[] arr = new int[10];
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt();
//            sum += arr[i];
//        }
//        int avg = sum/arr.length;
//        System.out.println("和为："+sum);
//        System.out.println("平均值为："+avg);
//        System.out.println(Arrays.toString(arr));

        //作业四
        System.out.println("作业四");
//        String[][] jack = new String[5][13];
//        for (int i = 0; i < jack.length; i++) {
//            if (i == 0) {
//                jack[i][0] = "大王";
//                jack[i][1] = "小王";
//            }else{
//                for (int j = 0; j < jack[i].length; j++) {
//                    if (j == 0) {
//                        jack[i][j] = "A";
//                    }else if (j == 10) {
//                        jack[i][j] = "J";
//                    }else if (j == 11) {
//                        jack[i][j] = "Q";
//                    }else if (j == 12) {
//                        jack[i][j] = "K";
//                    }else {
//                        jack[i][j] = String.valueOf(j+1);
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < jack.length; i++) {
//            System.out.println(Arrays.toString(jack[i]));
//        }
        String[] jack = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] flower = {"♥","♠","♦","♣"};
        String[][] jacker = new String[4][13];
        for (int i = 0; i < flower.length; i++) {
            for (int j = 0; j < jack.length; j++) {
                jacker[i][j] = flower[i] + jack[j];
                //System.out.print(flower[i]+jack[j]+"\t");

                    //jacker[k] = flower[i]+jack[j];
                //}
            }
            System.out.println();
        }
        for (int i = 0; i < jacker.length; i++) {
            System.out.println(Arrays.toString(jacker[i]));
        }

        System.out.println();
        Random random = new Random();
        int k = 0;
        for (int j = 0; j < 60; j++) {
            int f = random.nextInt(4);
            int f2 = random.nextInt(4);
            int n = random.nextInt(13);
            int n2 = random.nextInt(13);
            String temp = jacker[f][n];
            jacker[f][n] = jacker[f2][n2];
            jacker[f2][n2] = temp;
        }

        for (int i = 0; i < jacker.length; i++) {
            System.out.println(Arrays.toString(jacker[i]));
        }

//        String[] arr = new String[52];
//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 4; j++) {
//                arr[i] =
//            }
//        }
        String[] p1 = new String[17];
        String[] p2 = new String[17];
        String[] p3 = new String[17];
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                if (j == 0) {

                }
            }
            p1[i] = jacker[random.nextInt(4)][random.nextInt(13)];
        }

    }
}
