package com.Mar.test;

import sun.nio.cs.UTF_32;
import sun.text.normalizer.UTF16;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test02 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //String str = "adfdvb123fes";

        //charAt(int index)     返回指定索引处的字符
        //char c = str.charAt(5);
        //System.out.println(c);


        //int i = str.codePointCount(5, 7);
        //System.out.println(i);

        //compareTo()
        //如果参数字符串等于此字符串，则返回值0;
        //如果此字符串按字典顺序小于字符串参数，则返回一个小于0的值;
        //如果此字符串按字典顺序大于字符串参数，则返回一个大于0的值。
//        //区分大小写
//        String s = "abcdefghigklmnopqrstuvwxyz";
//        int b = s.compareTo("am");//以括号中参数为参照物（0）
//        System.out.println(b);
//        //不区分大小写
//        String s2 = "abcF";
//        int a = s2.compareToIgnoreCase("abF");
//        System.out.println(a);

        //将指定字符串连接到此字符串的结尾
//        String s = "admin";
//        String concat = s.concat("");
//        System.out.println(concat);

        //当且仅当此字符串包含指定的 char 值序列时，返回 true
//        String s = "ab";
//        boolean a = s.contains("b");
//        System.out.println(a);

//        //字符数组转化成字符串
//        char[] c = new char[]{'a','b','c','d','f','g'};
//        String s = String.copyValueOf(c);
//        System.out.println(s);
//        //返回初始位置（数字1）开始的定长（数字2）字符串
//        String s1 = String.copyValueOf(c, 5/*数字1*/, 2/*数字2*/);
//        System.out.println(s1);

//        //测试此字符串是否以指定的后缀结束,参数为空字符串或其本身时返回true
//        String s = "admin";
//        boolean n = s.endsWith("");
//        System.out.println(n);

        //比较字符串,只有完全相等时返回true
//        //区分大小写
//        String s = "admin";
//        boolean admin = s.equals("admin");
//        System.out.println(admin);
//        //区分大小写
//        boolean admIn = s.equalsIgnoreCase("AdmIn");
//        System.out.println(admIn);

        //格式化字符串
        //使用指定的语言环境、格式字符串和参数返回一个格式化字符串
        //%s    字符串转换符  符号先占位   添加的内容在后面
        String s = "admin";
        String format = String.format(s+"%n%s%s","feilong","asda");
        System.out.println(format);

        //转换成ASCII编码
//        String s = "123456admin";
//        byte[] bytes = s.getBytes();
//        System.out.println(Arrays.toString(bytes));
//        byte[] bytes1 = s.getBytes("Utf-16");
//        System.out.println(Arrays.toString(bytes1));

        //将字符从此字符串复制到目标字符数组
//        String s = "123456admin";
//        char[] c = new char[10];
//        s.getChars(2,5,c,1);
//        System.out.println(Arrays.toString(c));

        //返回指定字符在此字符串中第一次出现处的索引，找不到则返回-1
        //参数为int类型（Unicode编码,起始位置）起始位置不写默认从头
        //参数为String类型（"字符串",起始位置）起始位置不写默认从头
//        String s = "123456admin";
//        int i = s.indexOf(54,5);
//        System.out.println(i);
//        int i1 = s.indexOf("ad",4);
//        System.out.println(i1);

        //返回字符串对象的规范化表示形式
        //可以规范有堆地址的字符串直接引用
//        String s = "a";
//        String s2 = new String("a");
//        System.out.println(s == s2);
//        System.out.println(s == s2.intern());

    }
}
