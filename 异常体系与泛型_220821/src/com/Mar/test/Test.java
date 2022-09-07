package com.Mar.test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        int[] arr = new int[10];
        int a = 10;
        int i = 0;
        System.out.println(a);
        try {
            arr[a] = 10;
            int b = a / i;
            System.out.println(Arrays.toString(arr));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("下标越界");
        }finally {
            System.out.println("永远都会执行的代码块");
        }

    }
}
