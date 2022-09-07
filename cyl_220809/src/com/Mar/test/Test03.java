package com.Mar.test;

public class Test03 {
    public static void main(String[] args) {
        //当且仅当 length() 为 0 时返回 true
//        String s = "";
//        boolean empty = s.isEmpty();
//        System.out.println(empty);

        //返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
//        String s = "ad1ada";
//        int ad = s.lastIndexOf("ad");
//        System.out.println(ad);

        //字符串长度
//        String s = "admin";
//        int length = s.length();
//        System.out.println(length);

        //测试两个字符串区域是否相等
        //toffset - 此字符串中子区域的起始偏移量。
        //other - 字符串参数。
        //toffset - 字符串参数中子区域的起始偏移量。
        //len - 要比较的字符数。
//        String s = "admin";
//        boolean mi = s.regionMatches(3, "mi", 1, 2);
//        System.out.println(mi);

        //指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
//        String s = "Admin";
//        String replace = s.replace('A', 'a');
//        String replace2 = s.replace("A", "a");
//        System.out.println(replace);
//        System.out.println(replace2);

        //给定的值替换此字符串所有匹配给定值的字符串
//        String s = "adminadmin";
//        String s1 = s.replaceAll("ad", "kk");
//        System.out.println(s1);

        //返回一个新字符串，它是此字符串的一个子字符串
//        String s = "admin";
//        String substring = s.substring(2);
//        System.out.println(substring);
//        String substring1 = s.substring(2, 4);
//        System.out.println(substring1);

        //将此字符串转换为一个新的字符数组,它的内容被初始化为包含此字符串表示的字符序列
//        String s = "admin";
//        char[] chars = s.toCharArray();
//        System.out.println(chars);

        //清除首尾的空格
//        String s = " admin ";
//        int length = s.length();
//        System.out.println(length);
//        String trim = s.trim();
//        System.out.println(trim.length());


        char[] b = {'a','b','c','d'};
        String s = String.valueOf(b);
        System.out.println(s);

    }
}
