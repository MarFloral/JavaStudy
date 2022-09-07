package com.Mar.text;

public class Text {
    public static void main(String[] args) {

        //声明一个长度为10的数组  使用循环遍历出来所有的值
//        int[] arr = {12,56,89,78,45,12,23,55,63,15};
//        for (int i = 0; i < 10; i++) {
//            System.out.println(arr[i]);
//        }

        //百文买百鸡：
        //5文钱可以买1只公鸡，3文钱可以买一只母鸡，1文钱可以买3只小鸡
        //用100文钱买100只鸡，那么各有公鸡、母鸡、小鸡多少只?
        for(int a=1;a<=20; a++) {
            for (int b = 1; b <= 33; b++) {
                double c = 100 - a - b;
                //if (c % 3 == 0) {
                    if (5 * a + 3 * b + c / 5 == 100) {//c*0.2
                        System.out.println("公鸡有" + a + "只，母鸡有" + b + "只，小鸡有" + (int)c + "只");
                    }
                //} else {
                //    continue;
                //}
            }
        }

        for (int i = 1; i <= 10; i++) {
            if (i%3==0) {
                //break;//输出2次"SJT2207班"
                //continue;//输出7次"SJT2207班"
                System.out.println("SJT2207班");//输出13次"SJT2207班"
            }
            System.out.println("SJT2207班");
        }
    }
}
